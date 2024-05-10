package com.tcf.employeeprofileapp.remote.repository

import com.tcf.employeeprofileapp.remote.ApiService
import com.tcf.employeeprofileapp.remote.models.EmployeeModel
import com.tcf.employeeprofileapp.remote.models.Posts
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
class GeneralRepositoryImpl @Inject constructor (private val apiService: ApiService):GeneralRepository {
//    override suspend fun getPosts(): List<Posts> = apiService.getPost()

    override suspend fun getEmployees(): EmployeeModel = apiService.getEmployees()
}