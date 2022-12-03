package com.example.nagrada.screens

import android.content.Context
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
import com.example.nagrada.models.BlankNameModel

@Composable
fun MainScreen(context: Context) {
    val myBASE = context.applicationContext.getSharedPreferences("BASE", Context.MODE_PRIVATE)

    Image(painter = painterResource(id = R.drawable.bg_fon),
        contentDescription = "",
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.7f),
        contentScale = ContentScale.FillBounds)

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(2.dp)) {
        BlankName(BlankNameModel(myBASE.getString("avatar", "") as String,
            myBASE.getString("family", "") as String,
            myBASE.getString("name", "") as String))
        ListItems(context)
    }
}