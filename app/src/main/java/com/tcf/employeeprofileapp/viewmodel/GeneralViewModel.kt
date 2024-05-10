package com.tcf.employeeprofileapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tcf.employeeprofileapp.remote.callback.ApiResponseCallback
import com.tcf.employeeprofileapp.remote.models.EmployeeModel
import com.tcf.employeeprofileapp.remote.models.Posts
import com.tcf.employeeprofileapp.remote.repository.GeneralRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GeneralViewModel @Inject public constructor(
    private var appRepository: GeneralRepository
):ViewModel() {
    private val _data = MutableLiveData<ApiResponseCallback<EmployeeModel>>()
    val data: LiveData<ApiResponseCallback<EmployeeModel>>
        get() = _data

    fun getPosts(){
        viewModelScope.launch {
            try {
                _data.value = ApiResponseCallback.success(appRepository.getEmployees())
                Log.i("viewModel","Response found")
            }
            catch (e: Exception)
            {
                _data.value = ApiResponseCallback.error(null)
                Log.i("viewModel", "${e.message}")
            }
        }
    }
}