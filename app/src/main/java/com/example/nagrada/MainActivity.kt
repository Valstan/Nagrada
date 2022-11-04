package com.example.nagrada

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.nagrada.screens.MainScreen
import com.example.nagrada.ui.theme.NagradaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NagradaTheme {
                getData("token=3dh2h8wg38w382gd82g832&resource=table&fields=name=Валентин", this)
                MainScreen()
            }
        }
    }
}

private fun getData(commands: String, context: Context){
    val url = "https://nagradapi.store/nagrada/api?$commands"
    val queue = Volley.newRequestQueue(context)
    val sRequest = StringRequest(
        Request.Method.GET,
        url,
        {
            response ->
            Log.d("MyLog", "Response: $response")
        },
        {
            Log.d("MyLog", "VolleyError: $it")
        }
    )
    queue.add(sRequest)
}
