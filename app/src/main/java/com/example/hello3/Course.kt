package com.example.hello3.com.example.hello3

import com.google.gson.annotations.SerializedName
var courseId: String,
var courseName: String,
var courseCode: String,
var instructor: String,
var description: String = ""
@SerializedName("course_id") var courseId: String,
@SerializedName("course_name") var courseName: String,
@SerializedName("course_code") var courseCode: String,
@SerializedName("instructor") var instructor: String,
