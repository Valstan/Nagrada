package com.example.nagrada.bin

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.nagrada.models.ItemRowModel
import org.json.JSONObject

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListItems(context: Context) {
    val myBASE = context.applicationContext.getSharedPreferences("BASE", Context.MODE_PRIVATE)
    val data = myBASE.getString("data", "")?.let { JSONObject(it) }
    val sets = myBASE.getString("sets", "")?.let { JSONObject(it) }
    val itemList = listOf<ItemRowModel>()
    LazyColumn() {
        if (sets != null && data != null) {
            for (yearKey in 2022 until 2025) {
                val year = data.getJSONObject(yearKey.toString())
                for (monthKey in 1 until 13) {
                    val month = year.getJSONObject(monthKey.toString())
                    val monthList = listOf("Январь",
                        "Февраль",
                        "Март",
                        "Апрель",
                        "Май",
                        "Июнь",
                        "Июль",
                        "Август",
                        "Сентябрь",
                        "Октябрь",
                        "Ноябрь",
                        "Декабрь")
                    stickyHeader {
                        Text(modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .padding(12.dp), text = "$yearKey ${monthList[monthKey]}")
                    }
                    for (dayKey in 1 until 32) {
                        val day = month.getJSONArray(dayKey.toString())
                        itemList.plus(ItemRowModel(sets.get(day.get(0) as String) as String,
                            day.get(1) as Int,
                            day.get(2) as Int,
                            sets.get(day.get(3) as String) as String))

                    }
                }
            }
        } else {
            itemList.plus(ItemRowModel("Название дела",5,100,"рубль"))
            itemList.plus(ItemRowModel("Название дела2",4,70,"рубль"))
        }
        itemsIndexed(itemList)

        { _, item ->
            ItemRow(ItemsRow = item)
        }
    }
}