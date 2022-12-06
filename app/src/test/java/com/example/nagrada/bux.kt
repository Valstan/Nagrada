package com.example.nagrada.models

import android.content.Context
import android.content.SharedPreferences

class Bux(context: Context) {
    fun MyBase(context: Context): SharedPreferences? {
        return context.applicationContext.getSharedPreferences("BASE", Context.MODE_PRIVATE)
    }
}