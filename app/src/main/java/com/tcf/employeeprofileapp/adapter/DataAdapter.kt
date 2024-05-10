package com.tcf.employeeprofileapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tcf.employeeprofileapp.R
import com.tcf.employeeprofileapp.databinding.EmployeeListViewBinding
import com.tcf.employeeprofileapp.remote.models.Data

class DataAdapter (private val context: Context, private val list:List<Data>)
    : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = EmployeeListViewBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.employee_list_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data= list[position]
        val response = data

        with(holder){
            binding.tvId.text = response.firstName.toString()
            binding.tvbody.text = response.job.toString()
            binding.tvtitle.text = response.department.toString()
        }
    }

    override fun getItemCount(): Int = list.size

}