package com.example.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //esconder barra de suporte
        if(supportActionBar != null){
            supportActionBar!!.hide()
        }
    }
}