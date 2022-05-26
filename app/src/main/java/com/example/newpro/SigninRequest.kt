package com.example.newpro
import com.google.gson.annotations.SerializedName

class SigninRequest(@SerializedName("email") var email: String,
                    @SerializedName("password") var password: String)