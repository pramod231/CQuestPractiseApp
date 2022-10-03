package com.example.cquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.cquest.api.ApiClient
import com.example.cquest.api.ApiInterface
import com.example.cquest.models.RegisterUser
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etNumber: EditText
    private lateinit var etUserName: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var etOTP: EditText
    private lateinit var etCompanyCode: EditText

    private lateinit var btnSignUp: Button
    private lateinit var tvSignIn: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        // Initializing EditText & Button
        etName = findViewById(R.id.etName)
        etNumber = findViewById(R.id.etNumber)
        etUserName = findViewById(R.id.etUserName)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        etOTP = findViewById(R.id.etOTP)
        etCompanyCode = findViewById(R.id.etCompanyCode)

        btnSignUp = findViewById(R.id.btnSignUp)

        tvSignIn = findViewById(R.id.tvSignIn)

        // Initializing EditText & Button

        // Have an Account Go To SignIn
        tvSignIn.setOnClickListener {
            val i = Intent(this@SignUpActivity, SignInActivity::class.java)
            startActivity(i)
        }
        // Have an Account Go To SignIn


        btnSignUp.setOnClickListener {

            val name = etName.text.toString()
            val number = etNumber.text.toString()
            val email = etUserName.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()
            val otp = etOTP.text.toString()
            val companyCode = etCompanyCode.text.toString()

            signUp(name, number, email, password, companyCode)
        }


    }

    private fun signUp(
        name: String,
        number: String,
        email: String,
        password: String,
        companyCode: String
    ) {

        val retIn = ApiClient.getRetrofitInstance().create(ApiInterface::class.java)
        val registerInfo = RegisterUser(name, number, email, password, companyCode)

        retIn.register(registerInfo).enqueue(object : Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@SignUpActivity,t.message,Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                if (response.code() == 200) {

                    Toast.makeText(this@SignUpActivity, "Registration success!", Toast.LENGTH_SHORT).show()

                    val i = Intent(this@SignUpActivity,DashboardActivity::class.java)
                    startActivity(i)

                    Handler(Looper.getMainLooper()).postDelayed({


                    }, 2000)
                }

                else{


                    Toast.makeText(this@SignUpActivity, response.code().toString(), Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}




