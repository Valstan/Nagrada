package com.example.nagrada.bin

import android.annotation.SuppressLint
import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject



fun getData(
    context: Context,
    collection: String
) {
    val myObject = JSONObject()
    val myBASE = context.applicationContext.getSharedPreferences("BASE", Context.MODE_PRIVATE)
    myObject.put("token", myBASE.getString("token", ""))
    myObject.put("collection", collection)
    Volley.newRequestQueue(context).add(JsonObjectRequest(
        Request.Method.POST,
        "https://nagradapi.store/nagrada/get_data_sets",
        myObject,
        { return@JsonObjectRequest },
        {}))
}

@SuppressLint("CommitPrefEdits")
fun getDataWT(context: Context, command: String) {
    val myBASE = context.applicationContext.getSharedPreferences("BASE", Context.MODE_PRIVATE)
    val resp = getData(context, command).toString()
    if (resp == "wrong token") {
        myBASE.edit().putString("token", updateToken(context).toString())
        myBASE.edit().apply()
        myBASE.edit().putString(command, getData(context, command).toString())
        myBASE.edit().apply()
    }
    myBASE.edit().putString(command, resp)
    myBASE.edit().apply()
}

fun updateToken(
    context: Context) {
    val myObject = JSONObject()
    val myBASE = context.applicationContext.getSharedPreferences("BASE", Context.MODE_PRIVATE)
    myObject.put("login", myBASE.getString("login", ""))
    myObject.put("password", myBASE.getString("password", ""))
    Volley.newRequestQueue(context).add(JsonObjectRequest(
        Request.Method.POST,
        "https://nagradapi.store/nagrada/update_token",
        myObject,
        { return@JsonObjectRequest },
        {}))
}

fun greatePerson(
    context: Context) {
    val myObject = JSONObject()
    val myBASE = context.applicationContext.getSharedPreferences("BASE", Context.MODE_PRIVATE)
    myObject.put("login", myBASE.getString("login", ""))
    myObject.put("password", myBASE.getString("password", ""))
    myObject.put("name", myBASE.getString("name", ""))
    myObject.put("family", myBASE.getString("family", ""))
    myObject.put("avatar", myBASE.getString("avatar", ""))
    myObject.put("phone", myBASE.getString("phone", ""))
    myObject.put("email", myBASE.getString("email", ""))
    myObject.put("telegram", myBASE.getString("telegram", ""))
    myObject.put("theme", myBASE.getString("theme", ""))
    myObject.put("token", myBASE.getString("token", ""))
    Volley.newRequestQueue(context).add(JsonObjectRequest(
        Request.Method.POST,
        "https://nagradapi.store/nagrada/great_person",
        myObject,
        { return@JsonObjectRequest },
        {}))
}
