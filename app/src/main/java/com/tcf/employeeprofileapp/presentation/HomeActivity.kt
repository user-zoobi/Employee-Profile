package com.tcf.employeeprofileapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.tcf.employeeprofileapp.R
import com.tcf.employeeprofileapp.adapter.DataAdapter
import com.tcf.employeeprofileapp.adapter.HolidayAdapter
import com.tcf.employeeprofileapp.databinding.ActivityHomeBinding
import com.tcf.employeeprofileapp.remote.callback.Status
import com.tcf.employeeprofileapp.remote.models.Data
import com.tcf.employeeprofileapp.viewmodel.GeneralViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewModel:GeneralViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[GeneralViewModel::class.java]
        viewModel.getPosts()
        viewModel.data.observe(this)
        {
            when(it.status)
            {
                Status.LOADING->{}
                Status.SUCCESS->
                {
                    it.let {
                        val response = it.data!!.data
                        initViews(response)

                        val data = response[0]
                        binding.tvUserEmpId.text = "Employee No: ${data.employeeId}"
                        binding.tvUserName.text = " ${data.firstName}"
                    }
                }
                Status.ERROR->{}
                else->{}
            }
        }
    }

    private fun initViews(list:List<Data>)
    {

        binding.tvToolbar.text = "Employee Home"
        val snapHelper: SnapHelper = LinearSnapHelper()
        binding.rvEmployee.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL,false)
            adapter = DataAdapter(this@HomeActivity,list)
        }
        binding.rvHolidays.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL,false)
            adapter = HolidayAdapter(this@HomeActivity,list)
        }
        snapHelper.attachToRecyclerView(binding.rvEmployee)
        snapHelper.attachToRecyclerView(binding.rvHolidays)

        //Hello World
    }

}