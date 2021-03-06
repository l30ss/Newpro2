package com.example.newpro
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiList {

    //TODO : Register User
    @POST("register.php")
    fun doRegister(
        @Body signupRequest: SignupRequest
    ): Call<SignupResponse> // body data

    //TODO : Login User
    @POST("login.php")
    fun doLogin(
        @Body signinRequest: SigninRequest
    ): Call<SigninResponse> // body data


    //TODO : Get User
    @GET("get_user_detail.php")
    fun getUser(@Query("id") id: String): Call<UserResponse>
}
