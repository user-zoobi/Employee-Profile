package com.tcf.employeeprofileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tcf.employeeprofileapp.adapter.DataAdapter
import com.tcf.employeeprofileapp.databinding.ActivityMainBinding
import com.tcf.employeeprofileapp.presentation.HomeActivity
import com.tcf.employeeprofileapp.remote.callback.Status
import com.tcf.employeeprofileapp.remote.models.Data
import com.tcf.employeeprofileapp.remote.models.EmployeeModel
import com.tcf.employeeprofileapp.remote.models.Posts
import com.tcf.employeeprofileapp.viewmodel.GeneralViewModel
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        supportActionBar?.hide()
        setContentView(binding.root)

        Handler().postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        },3000)

    }



}