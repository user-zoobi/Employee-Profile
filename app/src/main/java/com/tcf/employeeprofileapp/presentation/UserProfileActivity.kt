package com.tcf.employeeprofileapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tcf.employeeprofileapp.R
import com.tcf.employeeprofileapp.databinding.ActivityHomeBinding
import com.tcf.employeeprofileapp.databinding.ActivityUserProfileBinding

class UserProfileActivity : AppCompatActivity() {

    private lateinit var binding:ActivityUserProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}