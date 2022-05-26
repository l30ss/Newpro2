package com.example.newpro

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeUser : AppCompatActivity() {

        var userId: String = "";

        private lateinit var txt_name: TextView
        private lateinit var txt_email: TextView
        private lateinit var btn_menu: Button


    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_home_user)

            setTitle("Home")

            val intent = getIntent()
            userId = intent.getIntExtra("id", 0).toString()

            txt_name = findViewById(R.id.txt_name) as TextView
            txt_email = findViewById(R.id.txt_email) as TextView
            btn_menu = findViewById(R.id.btnMenu) as Button

        btn_menu.setOnClickListener {
            val intent = Intent(this@HomeUser, MainActivity::class.java)
            startActivity(intent)

        }





        getUser()

        }



        private fun getUser() {
            ApiService.loginApiCall().getUser(userId).enqueue(object : Callback<UserResponse> {
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>) {
                    Log.d("Response User ::::", response.body().toString())
                    if (response.body()!!.status){
                        txt_name.setText(response.body()!!.data.username)
                        txt_email.setText(response.body()!!.data.email)
                    }
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
//                            Log.d("error::::",t?.message)
                }

            })
        }
    }
