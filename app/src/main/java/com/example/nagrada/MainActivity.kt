package com.example.nagrada

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.nagrada.bin.getDataWT
import com.example.nagrada.screens.MainScreen
import com.example.nagrada.ui.theme.NagradaTheme


class MainActivity : ComponentActivity() {

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NagradaTheme {
                val myBASE = getSharedPreferences("BASE", Context.MODE_PRIVATE)
                val sets = myBASE.getString("sets", "")
                val data = myBASE.getString("data", "")
                val person = myBASE.getString("person", "")
                if (person == "") {
                    myBASE.edit().putString("token", "0184e741-01d6-737b-80a1-9e5ef0586826")
                    myBASE.edit().apply()
                    myBASE.edit().putString("family", "Савиных")
                    myBASE.edit().apply()
                    myBASE.edit().putString("name", "Валентин")
                    myBASE.edit().apply()
                    myBASE.edit().putString("avatar", "https://sun9-13.userapi.com/impg/CcUafm8BH-evHA019kmLiElHhCcPmkiXVrpGzQ/l37RJzmQ8mI.jpg?size=484x480&quality=95&sign=5ccb5d814dfd4f510bdaa4a829dd89df&type=album")
                    myBASE.edit().apply()
                    myBASE.edit().putString("login", "valstan")
                    myBASE.edit().apply()
                    myBASE.edit().putString("password", "nitro2000")
                    myBASE.edit().apply()
//                    Authorization()
                }
                if (sets == "") {
                    getDataWT(this, "sets")
                }
                if (data == "") {
                    getDataWT(this, "data")
                }

//                LoaderScreen(this)

                MainScreen(this)
            }
        }
    }
}



