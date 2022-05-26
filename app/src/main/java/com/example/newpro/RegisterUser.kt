package com.example.newpro

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterUser : Activity(), View.OnClickListener {



    private lateinit var editTextTextPersonName: EditText
    private lateinit var editTextTextEmail: EditText
    private lateinit var editTextNumberPassword: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var btnconfirme: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)
        

        editTextTextEmail = findViewById(R.id.editTextTextEmail) as EditText
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName) as EditText
        editTextNumberPassword = findViewById(R.id.editTextNumberPassword) as EditText
        editTextPhone = findViewById(R.id.editTextPhone) as EditText
        btnconfirme = findViewById(R.id.btnconfirme) as Button

        btnconfirme.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnconfirme -> {
                if (validation()) {
                    val json = JSONObject()
                    json.put("email", editTextTextEmail.text.toString())
                    json.put("username", editTextTextPersonName.text.toString())
                    json.put("password", editTextNumberPassword.text.toString())
                    json.put("phone_number",editTextPhone.text.toString())


                    ApiService.loginApiCall().doRegister(
                        SignupRequest(
                            editTextTextEmail.text.toString(),
                            editTextTextPersonName.text.toString(),
                            editTextNumberPassword.text.toString(),
                            editTextPhone.text.toString(),
                        )
                    ).enqueue(object : Callback<SignupResponse> {
                        override fun onResponse(
                            call: Call<SignupResponse>,
                            response: Response<SignupResponse>
                        ) {

                            Log.d("Response::::", response.body().toString())
                            val loginResponse :  SignupResponse = response.body()!!
                            if (loginResponse.status){
                                finish()
                            }else{
                                Toast.makeText(applicationContext, response.body()!!.message, Toast.LENGTH_LONG).show()
                            }
                        }

                        override fun onFailure(call: Call<SignupResponse>, t: Throwable) {
                        }

                    })
                }
            }
        }
    }


    fun validation(): Boolean {
        var value = true

        val email = editTextTextEmail.text.toString().trim()
        val password = editTextNumberPassword.text.toString().trim()
        val name = editTextTextPersonName.text.toString().trim()
        val phone_number = editTextPhone.text.toString().trim()


        if (email.isEmpty()) {
            editTextTextEmail.error = "Email required"
            editTextTextEmail.requestFocus()
            value = false
        }


        if (password.isEmpty()) {
            editTextNumberPassword.error = "Password required"
            editTextNumberPassword.requestFocus()
            value = false
        }

        if (name.isEmpty()) {
            editTextTextPersonName.error = "Name required"
            editTextTextPersonName.requestFocus()
            value = false
        }

        if (phone_number.isEmpty()) {
            editTextPhone.error = "Name required"
            editTextPhone.requestFocus()
            value = false
        }

        return value
    }
}
