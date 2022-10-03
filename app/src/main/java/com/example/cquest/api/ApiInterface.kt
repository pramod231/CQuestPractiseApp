package com.example.cquest.api

import com.example.cquest.models.RegisterUser
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {

    @Headers("Accept: application/json")
    @POST("register")
    fun register(@Body registerUser : RegisterUser): Call<ResponseBody>

}
