package com.example.nagrada

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemRow(ItemRowModel: ItemRowModel) {

    var isExpanded by remember {mutableStateOf(false)}

    Row(
        modifier = Modifier
            .fillMaxSize().clip(RoundedCornerShape(20.dp))
            .padding(1.dp)
            .background(color = Color.LightGray.copy(alpha = 0.3f))

            .clickable { isExpanded = !isExpanded },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(0.08f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Text(
                text = ItemRowModel.dataItem.toString(),
                Modifier.fillMaxWidth(),
                color = Color.White,
                textAlign = TextAlign.Center,
                maxLines = 1
            )
        }
        Row(
            modifier = Modifier
                .fillMaxSize(0.8f)
                .background(color = Color.LightGray.copy(alpha = 0.2f)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Text(
                text = ItemRowModel.textItem,
                Modifier.fillMaxWidth(0.9f),
                fontSize = 18.sp
            )
            Text(
                text = ItemRowModel.ballsItem.toString(),
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
                text = ItemRowModel.nagradaCountItem.toString(),
                Modifier.fillMaxWidth(0.7f),
                color = Color.Yellow,
                textAlign = TextAlign.Center,
                maxLines = 1
            )
            Text(
                text = ItemRowModel.nagradaNameItem,
                maxLines = 1
            )
        }
    }
}
