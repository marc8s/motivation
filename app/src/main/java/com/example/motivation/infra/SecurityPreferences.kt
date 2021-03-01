package com.example.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context){

    private val mSharedPreferences = context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String){
        mSharedPreferences.edit().putString(key, value).apply()
    }
    fun getString(key: String) : String{
        //se não for nulo ?: se for nulo
        return mSharedPreferences.getString(key, "") ?: ""
    }

}