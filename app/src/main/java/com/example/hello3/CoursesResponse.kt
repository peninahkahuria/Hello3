package com.example.hello3.com.example.hello3

import com.google.gson.annotations.SerializedName
data class CoursesResponse(
    @SerializedName("courses") var courses: List<Courses>
)

class Courses {

}
