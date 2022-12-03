package com.example.nagrada

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.nagrada.screens.LoaderScreen
import com.example.nagrada.screens.MainScreen
import com.example.nagrada.ui.theme.NagradaTheme


class MainActivity : ComponentActivity() {

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NagradaTheme {

                LoaderScreen(this)

                MainScreen(this)
            }
        }
    }
}



