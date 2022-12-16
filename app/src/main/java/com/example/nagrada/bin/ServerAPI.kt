package com.example.nagrada.bin

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.nagrada.models.PersonModel
import org.json.JSONObject


fun getData(
    context: Context,
    collection: String,
) {
    val myObject = JSONObject()
    val myBASE = context.applicationContext.getSharedPreferences("BASE", Context.MODE_PRIVATE)
    val personIt = PersonModel(myBASE.getString("person", "").toString())
    myObject.put("token", personIt.token)
    myObject.put("collection", collection)
    Log.d("Valstan", myObject.toString())
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
    val editor = myBASE.edit()
    val resp = getData(context, command).toString()
    Log.d("Valstan", resp)
    if (resp == "wrong token") {
        val personIt = PersonModel(myBASE.getString("person", "").toString())
        personIt.token = updateToken(context).toString()
        editor.putString("person", personIt.toString())
        editor.apply()
        val getDataFrom = getData(context, command).toString()
        Log.d("Valstan", getDataFrom)
        editor.putString(command, getDataFrom)
        editor.apply()
    }
    editor.putString(command, resp)
    editor.apply()
    myBASE.getString("data", "").toString().let { Log.d("Valstan", it) }
    myBASE.getString("sets", "").toString().let { Log.d("Valstan", it) }
}

fun updateToken(
    context: Context) {
    val myObject = JSONObject()
    val myBASE = context.applicationContext.getSharedPreferences("BASE", Context.MODE_PRIVATE)
    val personIt = PersonModel(myBASE.getString("person", "").toString())
    myObject.put("login", personIt.login)
    myObject.put("password", personIt.password)
    Log.d("Valstan", myObject.toString())
    Volley.newRequestQueue(context).add(
        JsonObjectRequest(
            Request.Method.POST,
            "https://nagradapi.store/nagrada/update_token",
            myObject,
            { return@JsonObjectRequest },
            {},
        ),
    )
}

//fun greatePerson(
//    context: Context) {
//    val myObject = JSONObject()
//    val myBASE = context.applicationContext.getSharedPreferences("BASE", Context.MODE_PRIVATE)
//    myObject.put("login", myBASE.getString("login", ""))
//    myObject.put("password", myBASE.getString("password", ""))
//    myObject.put("name", myBASE.getString("name", ""))
//    myObject.put("family", myBASE.getString("family", ""))
//    myObject.put("avatar", myBASE.getString("avatar", ""))
//    myObject.put("phone", myBASE.getString("phone", ""))
//    myObject.put("email", myBASE.getString("email", ""))
//    myObject.put("telegram", myBASE.getString("telegram", ""))
//    myObject.put("theme", myBASE.getString("theme", ""))
//    myObject.put("token", myBASE.getString("token", ""))
//    Volley.newRequestQueue(context).add(JsonObjectRequest(
//        Request.Method.POST,
//        "https://nagradapi.store/nagrada/great_person",
//        myObject,
//        { return@JsonObjectRequest },
//        {}))
//}
