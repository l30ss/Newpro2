package com.example.newpro
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : Activity(), View.OnClickListener {
    //คำสั่ง private lateinit var เป็นตัวแปลที่ประกาษให้หน้านั้นๆ เรียกใช้ได้เพียงเเค่หน้าเดียว จะเรียกใช้ตัสแปลจากหน้าอื่นไม่ได้
    private lateinit var Editextmail: EditText
    private lateinit var EditTextpassword : EditText
    private lateinit var button_login : Button
    private lateinit var txt_sign_up : TextView
//    ในการใช้ฟังชั้น override fun จะต้องมี คำสั่ง setContentView(R.layout.activity_login) ทุกครั้ง เพื่อให้โปรเเกรมเเสดงหน้า เนื้อหาออกหน้า Ui
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Editextmail = findViewById(R.id.Editextmail) as EditText
        EditTextpassword = findViewById(R.id.EditTextpassword) as  EditText
        button_login = findViewById(R.id.button_login) as Button
        txt_sign_up = findViewById(R.id.txt_sign_up)  as TextView



        button_login.setOnClickListener(this)
        txt_sign_up.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.txt_sign_up -> {
                startActivity(Intent(this@LoginActivity, RegisterUser::class.java))
            }
            R.id.button_login -> {

                if (validation()) {
                    val json = JSONObject()
                    json.put("email", Editextmail.text.toString())
                    json.put("password", EditTextpassword.text.toString())

                    ApiService.loginApiCall().doLogin(
                        SigninRequest(
                            Editextmail.text.toString(),EditTextpassword.text.toString()
                        )
//enqueue เข้าตามคิว
                    ).enqueue(object : Callback<SigninResponse> {
                        override fun onResponse(
                            call: Call<SigninResponse>,
                            response: Response<SigninResponse>) {

//                            Log.d("Response::::", response.body().toString())
                            if (response.body()!!.status){
                                finish()
                                val intent = Intent(this@LoginActivity, HomeUser::class.java)
                                intent.putExtra("id",response.body()!!.data.id)
                                startActivity(intent)
                            }else{
                                Toast.makeText(applicationContext, response.body()!!.message, Toast.LENGTH_LONG).show()
                            }
                        }

                        override fun onFailure(call: Call<SigninResponse>, t: Throwable) {
                        }

                    })
                }
            }
        }
    }


    fun validation(): Boolean {
        var value = true

        val password = EditTextpassword.text.toString().trim()
        val name = Editextmail.text.toString().trim()

        if (password.isEmpty()) {
            EditTextpassword.error = "Password required"
            EditTextpassword.requestFocus()
            value = false
        }

        if (name.isEmpty()) {
            Editextmail.error = "Email required"
            Editextmail.requestFocus()
            value = false
        }

        return value;
    }

}

