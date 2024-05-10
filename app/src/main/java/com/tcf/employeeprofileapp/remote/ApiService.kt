package com.tcf.employeeprofileapp.remote

import com.tcf.employeeprofileapp.remote.Routes.ENDPOINTS.posts
import com.tcf.employeeprofileapp.remote.models.EmployeeModel
import retrofit2.http.GET

interface ApiService {
//    @GET(posts)
//    suspend fun getPost():List<Posts>

    @GET(posts)
    suspend fun getEmployees():EmployeeModel


}