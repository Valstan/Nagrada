package com.example.nagrada.screens

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nagrada.R
import com.example.nagrada.bin.BlankName
import com.example.nagrada.bin.ListItems


@Composable
fun MainScreen(context: Context) {

    Log.d("Valstan", "Зашли в Майнскрин")

    Image(painter = painterResource(id = R.drawable.bg_fon),
        contentDescription = "",
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.7f),
        contentScale = ContentScale.FillBounds)

    Column(modifier = Modifier
        .fillMaxSize(0.9f)
        .padding(2.dp)) {
        Log.d("Valstan", "Зашли в Майнскрин в Колумн")
        BlankName(context)
        ListItems(context)
    }
}

