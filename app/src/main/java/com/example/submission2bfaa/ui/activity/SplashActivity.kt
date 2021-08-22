package com.example.submission2bfaa.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.submission2bfaa.databinding.ActivitySpashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var splashBinding: ActivitySpashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySpashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

}