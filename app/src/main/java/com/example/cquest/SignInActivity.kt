package com.example.cquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SignInActivity : AppCompatActivity() {

    private lateinit var etLoginPassword : EditText
    private lateinit var etLoginUsername : EditText
    private lateinit var btnSignIn : Button
    private lateinit var tvSignUp : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // Initializing EditText & Button
        etLoginPassword = findViewById(R.id.etLoginPassword)
        etLoginUsername = findViewById(R.id.etLoginUserName)
        btnSignIn = findViewById(R.id.btnSignIn)
        tvSignUp = findViewById(R.id.tvSignUp)

        // Initializing EditText & Button

        // Don't Have an Account Go To Sign Up
        tvSignUp.setOnClickListener{
            val i = Intent(this@SignInActivity, SignUpActivity::class.java)
            startActivity(i)
        }
        // Don't Have an Account Go To Sign Up
    }
}