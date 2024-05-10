package com.tcf.employeeprofileapp.remote.repository

import com.tcf.employeeprofileapp.remote.models.EmployeeModel
import com.tcf.employeeprofileapp.remote.models.Posts

interface GeneralRepository {

//    suspend fun getPosts():List<Posts>
    suspend fun getEmployees():EmployeeModel

}