package com.tcf.employeeprofileapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tcf.employeeprofileapp.R
import com.tcf.employeeprofileapp.databinding.EmployeeListViewBinding
import com.tcf.employeeprofileapp.databinding.HolidaysListViewBinding
import com.tcf.employeeprofileapp.remote.models.Data

class HolidayAdapter (private val context: Context, private val list:List<Data>)
    : RecyclerView.Adapter<HolidayAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = HolidaysListViewBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holidays_list_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data= list[position]
        val response = data

        with(holder){
            binding.ivHolidays.setImageResource(R.drawable.holidays)
        }
    }

    override fun getItemCount(): Int = list.size

}