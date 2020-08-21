package com.example.hello3.com.example.hello3

import android.widget.Toast
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hello3.ApiClient
import com.example.hello3.ApiInterface
import com.example.hello3.CoursesRecyclerViewAdapter
import com.example.hello3.R
import kotlinx.android.synthetic.main.row_course_item.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)
        var courseList = listOf<course>(
            Course("1", "Python", "PY 101", "James Neumann", "Python Intro"),
            Course("2", "Android", "AND 201", "Anne Elson", "Android development training"),
            Course("3", "Database", "DB 304", "Kamwe Wema", "Database administration and development"),
            Course("4", "Network", "DIS 202", "Betty Crocker", "Netwok Config for modern apps")
        )
        rvCourses.layoutManager = LinearLayoutManager(baseContext)
        rvCourses.adapter = CoursesRecyclerViewAdapter(courseList)
        fetchCourses()
    }
    fun fetchCourses() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")
        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val coursesCall = apiClient.getCourses("Bearer " + accessToken)
        coursesCall.enqueue(object : Callback<CoursesResponse> {
            override fun onFailure(call: Call<CoursesResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
            override fun onResponse(
                call: Call<CoursesResponse>,
                response: Response<CoursesResponse>
            ) {
                if (response.isSuccessful) {
                    var courseList = response.body()?.courses as List<Course>
                    var coursesAdapter = CoursesRecyclerViewAdapter(courseList)
                    val rvCourses: Nothing? = null
                    rvCourses.layoutManager = LinearLayoutManager(baseContext)
                    val rvCourses = null
                    rvCourses.adapter = coursesAdapter
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }