package com.example.hello3

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("register")
    fun registerStudent(@Body requestBody: RequestBody): Call<RegistrationResponse>
}