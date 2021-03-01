package com.example.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //esconder barra de suporte
        if(supportActionBar != null){
            supportActionBar!!.hide()
        }

        buttonSave.setOnClickListener(this);
    }

    override fun onClick(view: View) {
        val id = view.id
        if(id == R.id.buttonSave){
            handleSave()
        }
    }

    private fun handleSave(){
        val name = editName.text.toString()
        if(name!=""){
            startActivity(Intent(this, MainActivity::class.java))
        }else{
            Toast.makeText(this, getString(R.string.informenome), Toast.LENGTH_SHORT).show()
        }
    }
}