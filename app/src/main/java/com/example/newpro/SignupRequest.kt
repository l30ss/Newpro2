package com.example.newpro

import com.google.gson.annotations.SerializedName

class SignupRequest(
    @SerializedName("email") var email: String,
    @SerializedName("username") var username: String,
    @SerializedName("password") var password: String,
    @SerializedName("phone_number") var phone_number: String


)