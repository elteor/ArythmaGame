package com.elteor.arythmagame.data

import android.content.Context
import android.content.SharedPreferences

class SharedPrefs(context : Context) {
    private var sharedPref :SharedPreferences = context.getSharedPreferences("prefs", Context.MODE_PRIVATE)

    fun setMode(mode: String){
        setData("mode", mode)
    }

    fun getMode() : String{
        return sharedPref.getString("mode","easy")!!
    }

    private fun setData(location : String, value : String){
        val editor = sharedPref.edit()
        editor.putString(location, value)
        editor.apply()
    }
}