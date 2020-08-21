package com.example.hello3.com.example.hello3

import com.example.hello3.Student
import com.google.gson.annotations.SerializedName

class RegistrationResponse(
    @SerializedName("message") var message: String,
    @SerializedName("student") var student: Student
)