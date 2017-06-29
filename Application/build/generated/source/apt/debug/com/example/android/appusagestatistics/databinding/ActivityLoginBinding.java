package com.example.android.appusagestatistics.databinding;
import com.example.android.appusagestatistics.R;
import com.example.android.appusagestatistics.BR;
import android.view.View;
public class ActivityLoginBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.reg_login_toggle, 1);
        sViewsWithIds.put(R.id.login_form, 2);
        sViewsWithIds.put(R.id.email, 3);
        sViewsWithIds.put(R.id.password, 4);
        sViewsWithIds.put(R.id.sign_in, 5);
        sViewsWithIds.put(R.id.registration_form, 6);
        sViewsWithIds.put(R.id.heading, 7);
        sViewsWithIds.put(R.id.reg_first_phase, 8);
        sViewsWithIds.put(R.id.email_login_form, 9);
        sViewsWithIds.put(R.id.first_name, 10);
        sViewsWithIds.put(R.id.last_name, 11);
        sViewsWithIds.put(R.id.mobile_number, 12);
        sViewsWithIds.put(R.id.cnic, 13);
        sViewsWithIds.put(R.id.gender, 14);
        sViewsWithIds.put(R.id.male, 15);
        sViewsWithIds.put(R.id.female, 16);
        sViewsWithIds.put(R.id.Address, 17);
        sViewsWithIds.put(R.id.city, 18);
        sViewsWithIds.put(R.id.next, 19);
        sViewsWithIds.put(R.id.reg_second_phase, 20);
        sViewsWithIds.put(R.id.up, 21);
        sViewsWithIds.put(R.id.reg_email, 22);
        sViewsWithIds.put(R.id.reg_password, 23);
        sViewsWithIds.put(R.id.reg_confirm_pass, 24);
        sViewsWithIds.put(R.id.security_keyword, 25);
        sViewsWithIds.put(R.id.reg, 26);
    }
    // views
    public final android.widget.EditText Address;
    public final android.widget.EditText city;
    public final android.widget.EditText cnic;
    public final android.widget.EditText email;
    public final android.widget.LinearLayout emailLoginForm;
    public final android.widget.RadioButton female;
    public final android.widget.EditText firstName;
    public final android.widget.RadioGroup gender;
    public final android.widget.TextView heading;
    public final android.widget.EditText lastName;
    public final android.widget.LinearLayout loginForm;
    public final android.widget.RadioButton male;
    private final android.widget.RelativeLayout mboundView0;
    public final android.widget.EditText mobileNumber;
    public final android.support.design.widget.FloatingActionButton next;
    public final android.widget.EditText password;
    public final android.widget.Button reg;
    public final android.widget.EditText regConfirmPass;
    public final android.widget.EditText regEmail;
    public final android.widget.LinearLayout regFirstPhase;
    public final android.widget.Button regLoginToggle;
    public final android.widget.EditText regPassword;
    public final android.widget.LinearLayout regSecondPhase;
    public final android.widget.RelativeLayout registrationForm;
    public final android.widget.EditText securityKeyword;
    public final android.widget.Button signIn;
    public final android.support.design.widget.FloatingActionButton up;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityLoginBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 27, sIncludes, sViewsWithIds);
        this.Address = (android.widget.EditText) bindings[17];
        this.city = (android.widget.EditText) bindings[18];
        this.cnic = (android.widget.EditText) bindings[13];
        this.email = (android.widget.EditText) bindings[3];
        this.emailLoginForm = (android.widget.LinearLayout) bindings[9];
        this.female = (android.widget.RadioButton) bindings[16];
        this.firstName = (android.widget.EditText) bindings[10];
        this.gender = (android.widget.RadioGroup) bindings[14];
        this.heading = (android.widget.TextView) bindings[7];
        this.lastName = (android.widget.EditText) bindings[11];
        this.loginForm = (android.widget.LinearLayout) bindings[2];
        this.male = (android.widget.RadioButton) bindings[15];
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mobileNumber = (android.widget.EditText) bindings[12];
        this.next = (android.support.design.widget.FloatingActionButton) bindings[19];
        this.password = (android.widget.EditText) bindings[4];
        this.reg = (android.widget.Button) bindings[26];
        this.regConfirmPass = (android.widget.EditText) bindings[24];
        this.regEmail = (android.widget.EditText) bindings[22];
        this.regFirstPhase = (android.widget.LinearLayout) bindings[8];
        this.regLoginToggle = (android.widget.Button) bindings[1];
        this.regPassword = (android.widget.EditText) bindings[23];
        this.regSecondPhase = (android.widget.LinearLayout) bindings[20];
        this.registrationForm = (android.widget.RelativeLayout) bindings[6];
        this.securityKeyword = (android.widget.EditText) bindings[25];
        this.signIn = (android.widget.Button) bindings[5];
        this.up = (android.support.design.widget.FloatingActionButton) bindings[21];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
        }
        return false;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ActivityLoginBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityLoginBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityLoginBinding>inflate(inflater, com.example.android.appusagestatistics.R.layout.activity_login, root, attachToRoot, bindingComponent);
    }
    public static ActivityLoginBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityLoginBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.android.appusagestatistics.R.layout.activity_login, null, false), bindingComponent);
    }
    public static ActivityLoginBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityLoginBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_login_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityLoginBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}