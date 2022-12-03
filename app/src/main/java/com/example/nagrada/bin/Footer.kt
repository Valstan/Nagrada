package com.example.nagrada.bin

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Footer() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(15.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Нижняя часть с итоговыми суммами")
        }
    }
}