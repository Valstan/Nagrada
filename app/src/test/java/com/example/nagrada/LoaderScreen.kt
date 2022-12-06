package com.example.nagrada.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.nagrada.bin.getDataWT


@Composable
fun LoaderScreen(context: Context) {

    Card(
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            Modifier
                .padding(12.dp)
                .background(Color.White)

        ) {
            Text(
                text = "Loading.. Please wait..",
                Modifier
                    .padding(8.dp), textAlign = TextAlign.Center
            )

            CircularProgressIndicator(
                strokeWidth = 4.dp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            )
        }
    }

    val myBASE = context.getSharedPreferences("BASE", Context.MODE_PRIVATE)
    val sets = myBASE.getString("sets", "")
    val data = myBASE.getString("data", "")
    val person = myBASE.getString("person", "")
    if (person == "") {
        Authorization()
    }
    if (sets == "") {
        getDataWT(context, "sets")
    }
    if (data == "") {
        getDataWT(context, "data")
    }
}
