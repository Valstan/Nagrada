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

@Composable
fun ItemRow(ItemsRow: ItemRowModel) {

    Row(
        modifier = Modifier
            .fillMaxSize().clip(RoundedCornerShape(20.dp))
            .padding(1.dp)
            .background(color = Color.LightGray.copy(alpha = 0.3f)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(0.7f)
                .background(color = Color.LightGray.copy(alpha = 0.2f)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Text(
                text = ItemsRow.textItem,
                Modifier.fillMaxWidth(0.9f),
                fontSize = 18.sp
            )
            Text(
                text = ItemsRow.ballsItem.toString(),
                Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.Red
            )
        }
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Text(
                text = ItemsRow.nagradaCountItem.toString(),
                Modifier.fillMaxWidth(0.7f),
                color = Color.Yellow,
                textAlign = TextAlign.Center,
                maxLines = 1
            )
            Text(
                text = ItemsRow.nagradaNameItem,
                maxLines = 1
            )
        }
    }
}
