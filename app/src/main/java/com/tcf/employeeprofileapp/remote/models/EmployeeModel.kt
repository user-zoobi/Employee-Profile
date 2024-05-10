package com.tcf.employeeprofileapp.remote.models

import com.google.gson.annotations.SerializedName

data class EmployeeModel (
    @SerializedName("data" ) var data : ArrayList<Data>
)
data class Data (
    @SerializedName("employee_id" ) var employeeId : Int?    = null,
    @SerializedName("first_name"  ) var firstName  : String? = null,
    @SerializedName("job"         ) var job        : String? = null,
    @SerializedName("department"  ) var department : String? = null
)
