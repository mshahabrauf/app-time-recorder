package com.example.android.appusagestatistics.network;


import com.example.android.appusagestatistics.model.ApplicationLog;
import com.example.android.appusagestatistics.model.LoginResponse;
import com.example.android.appusagestatistics.model.Register;
import com.example.android.appusagestatistics.model.Response;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Author: Muhammad Shahab
 * Date: 5/5/17.
 * Description: Interface that contains the services
 */

public interface WebServices {

    @FormUrlEncoded
    /*Employer login*/
    @POST(ApiEndPoints.LOGIN)
    Call<LoginResponse> loginUser(@FieldMap HashMap<String, String> login);


    /*Employer login*/
    @POST(ApiEndPoints.REGISTER)
    Call<LoginResponse> registration(@Body Register login);

    @POST(ApiEndPoints.ACTIVITY_LOGS)
    Call<Response> postActivityLogs(@Body ApplicationLog applicationLog);
}
