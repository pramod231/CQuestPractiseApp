package com.example.cquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val btnSignUp  = findViewById<Button>(R.id.btnGoToSignUp)
        val btnSignIn  = findViewById<Button>(R.id.btnGoToSignIn)

        btnSignUp.setOnClickListener{
            val intent = Intent(this@WelcomeActivity,SignUpActivity::class.java)
            startActivity(intent)

        }

        btnSignIn.setOnClickListener{
            val intent = Intent(this@WelcomeActivity,SignInActivity::class.java)
            startActivity(intent)

        }
    }
}