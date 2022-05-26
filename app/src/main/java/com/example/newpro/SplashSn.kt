

package com.example.newpro

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity


@Suppress("DEPRECATION")
class SplashSn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_sn)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
        )

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
     android.os.Handler().postDelayed(
         {
             val intent = Intent(this, LoginActivity::class.java) //link
             startActivity(intent)
             finish()
         },
         5000,
     )
    }
}



