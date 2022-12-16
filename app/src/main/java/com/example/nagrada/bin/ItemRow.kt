package com.example.nagrada.bin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nagrada.models.ItemRowModel
import org.json.JSONObject

@Composable
fun ItemRow(ItemsRow: ItemRowModel, sets: JSONObject) {

    Row(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(10.dp))
            .padding(1.dp)
            .background(color = Color.LightGray.copy(alpha = 0.3f)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {

        Text(
            text = sets.get(ItemsRow.text).toString(),
            Modifier
                .fillMaxWidth(0.65f)
                .padding(start = 3.dp),
            textAlign = TextAlign.Start,
            fontSize = 20.sp
        )
        Text(
            text = ItemsRow.ball.toString(),
            Modifier.fillMaxWidth(0.25f),
            textAlign = TextAlign.Start,
            color = Color.Red,
            fontSize = 20.sp,
            maxLines = 1
        )

        Text(
            text = ItemsRow.cash.toString(),
            Modifier.fillMaxWidth(0.65f),
            color = Color.Yellow,
            textAlign = TextAlign.End,
            fontSize = 16.sp,
            maxLines = 1
        )
        Text(
            text = sets.get(ItemsRow.currency).toString(),
            fontSize = 16.sp,
            color = Color.Black,
            maxLines = 1
        )

    }
}
