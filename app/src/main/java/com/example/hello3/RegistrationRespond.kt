package com.example.hello3

import com.google.gson.annotations.SerializedName

data class RegistrationResponse(
    @SerializedName("message") var message: String,
    @SerializedName("student") var student: Student
)