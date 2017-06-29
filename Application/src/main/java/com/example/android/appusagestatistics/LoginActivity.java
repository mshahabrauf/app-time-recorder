package com.example.android.appusagestatistics;

import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.example.android.appusagestatistics.databinding.ActivityLoginBinding;
import com.example.android.appusagestatistics.extras.ValidationUtility;
import com.example.android.appusagestatistics.model.Login;
import com.example.android.appusagestatistics.model.LoginResponse;
import com.example.android.appusagestatistics.model.Register;
import com.example.android.appusagestatistics.model.profile.User;
import com.example.android.appusagestatistics.network.NetworkContants;
import com.example.android.appusagestatistics.network.RestClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends ParentActivity  {

    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private boolean login = true;

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        setListeners();

    }

    private void setListeners() {
        binding.password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });
        binding.regConfirmPass.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptSignUp();
                    return true;
                }
                return false;
            }
        });

        binding.regLoginToggle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login)
                {
                    login = false;
                    binding.registrationForm.setVisibility(View.VISIBLE);
                    binding.loginForm.setVisibility(View.INVISIBLE);
                    binding.regLoginToggle.setText(R.string.login);
                }
                else
                {
                    login = true;
                    binding.loginForm.setVisibility(View.VISIBLE);
                    binding.registrationForm.setVisibility(View.INVISIBLE);
                    binding.regLoginToggle.setText(R.string.registration);
                }
            }
        });

        binding.signIn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        binding.reg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptSignUp();
            }
        });

        binding.next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validatePhaseOne()) {
                    binding.regFirstPhase.setVisibility(View.INVISIBLE);
                    binding.regSecondPhase.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.up.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.regFirstPhase.setVisibility(View.VISIBLE);
                binding.regSecondPhase.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void attemptSignUp() {


        if(validatePhaseTwo())
        {
            showProgress();
            final Register register = new Register();
            register.setAddress(binding.Address.getText().toString());
            register.setCity(binding.city.getText().toString());
            register.setCnic(binding.cnic.getText().toString());
            register.setFirst_name(binding.firstName.getText().toString());
            register.setLast_name(binding.lastName.getText().toString());
            register.setPhone(binding.mobileNumber.getText().toString());
            register.setUsername(binding.regEmail.getText().toString());
            register.setPassword(binding.regPassword.getText().toString());
            register.setRetype_password(binding.regConfirmPass.getText().toString());
            register.setGender(binding.gender.getCheckedRadioButtonId()==R.id.male?"male":"female");
            register.setSecurity_keywords(binding.securityKeyword.getText().toString());
            RestClient.getAuthRestAdapter().registration(register).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                    hideProgress();
                    if (response.isSuccessful()&&response.body()!=null&&response.body().getMeta().getSuccess())
                    {
                        User.getInstance().setAccess_token(response.body().getAccess_token());
                        sharedPreferences.saveUser();
                        openActivityWithFinish(AppUsageStatisticsActivity.class);
                    }
                    else if (response.body()!=null)
                    {
                        showMessage(binding.getRoot(),response.body().getMeta().getMessage_detail());
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    hideProgress();
                    onFailureResponse(binding.getRoot(),t);
                }
            });
        }
    }

    private boolean validatePhaseOne() {
        if(!ValidationUtility.edittextValidator(binding.firstName)||
                !ValidationUtility.edittextValidator(binding.lastName)||
                !ValidationUtility.edittextValidator(binding.Address)||
                !ValidationUtility.edittextValidator(binding.city)||
                !ValidationUtility.edittextValidator(binding.cnic))
            return false;

        else if (binding.gender.getId()==View.NO_ID)
        {
            showMessage(binding.getRoot(),getString(R.string.gender_must_be_selected));
            return false;
        }
        return true;
    }

    private boolean validatePhaseTwo() {
        if(!ValidationUtility.edittextValidator(binding.securityKeyword))
            return false;
        else if (!isEmailValid(binding.regEmail.getText().toString()))
        {
            showMessage(binding.getRoot(),getString(R.string.error_invalid_email));
            return false;
        }
        else if (!isPasswordValid(binding.regPassword.getText().toString()))
        {
            showMessage(binding.getRoot(),getString(R.string.error_incorrect_password));
            return false;
        }
        else if (!binding.regPassword.getText().toString().equals(binding.regConfirmPass.getText().toString()))
        {
            showMessage(binding.getRoot(),getString(R.string.pass_mismatch));
            return false;
        }
        return true;
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {

        // Store values at the time of the login attempt.
        String email = binding.email.getText().toString();
        String password = binding.password.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            showMessage(binding.getRoot(),getString(R.string.error_invalid_password));
            focusView = binding.password;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            showMessage(binding.getRoot(),getString(R.string.error_field_required));
            focusView = binding.email;
            cancel = true;
        } else if (!isEmailValid(email)) {
            showMessage(binding.getRoot(),getString(R.string.error_invalid_email));
            focusView = binding.email;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            loginUser(email,password);
        }
    }

    private void loginUser(String email, String password) {
        showProgress();
        Login login = new Login(email,password);
        RestClient.getAuthRestAdapter().loginUser(login.getMapObject()).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                hideProgress();
                if (response.isSuccessful())
                {
                    User.getInstance().
                            setAccess_token(response.body().getAccess_token()).
                            setToken_type(response.body().getToken_type());
                    sharedPreferences.saveUser();
                    openActivityWithFinish(AppUsageStatisticsActivity.class);
                }
                else if (response.code() == NetworkContants.UNAUTHORIZED)
                {
                    showMessage(binding.getRoot(),"Invalid username or password.");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                hideProgress();
                onFailureResponse(binding.getRoot(),t);
            }
        });
    }

    private boolean isEmailValid(String email) {
        return email.length() >= 6;
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 6;
    }



}

