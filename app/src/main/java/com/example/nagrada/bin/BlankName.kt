package com.example.nagrada.bin

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.nagrada.models.BlankNameModel

@Composable
fun BlankName(BlankNameModel: BlankNameModel) {
    Row(
        Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(
            painter = rememberImagePainter("https://picsum.photos/300/300"),
            contentDescription = BlankNameModel.shortNameChild,
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
            Text(text = BlankNameModel.fullNameChild, color = Color.White)
            Row() {
                Text(text = "Всего богатств: ")
                Text(text = "1570", color = Color.White)
                Text(text = " руб.")
            }

        }
    }
}
