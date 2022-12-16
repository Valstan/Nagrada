package com.example.nagrada.bin

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import org.json.JSONObject

@Composable
fun BlankName(context: Context) {
    val myBASE = context.applicationContext.getSharedPreferences("BASE", Context.MODE_PRIVATE)
    val person = JSONObject(myBASE.getString("person", "").toString())

    Row(
        Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(
            painter = rememberAsyncImagePainter(person.get("avatar")),
            contentDescription = "${person.get("family")} ${person.get("name")}",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .padding(start = 5.dp)
                .fillMaxWidth(0.2f)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .padding(start = 5.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {


            Text(text = person.get("name").toString() + " " + person.get("family"), color = Color.White)


            Row {
                Text(text = "Всего богатств: ")
                Text(text = "1570", color = Color.White)
                Text(text = " руб.")
            }
        }
    }
}
