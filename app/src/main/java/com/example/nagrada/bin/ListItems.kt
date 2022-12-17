package com.example.nagrada.bin

import android.content.Context
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.nagrada.models.DayModel
import com.example.nagrada.models.ItemRowModel
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListItems(context: Context) {
    val myBASE = context.applicationContext.getSharedPreferences("BASE", Context.MODE_PRIVATE)
    val monthList = JSONArray(myBASE.getString("monthlist", ""))
//    var lastDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMdd"))
    var lastDate = "220101"
    val data = JSONArray(myBASE.getString("data", ""))
    val sets = JSONObject(myBASE.getString("sets", "").toString())
    val dataList = mutableListOf<DayModel>()
    for (i in 0 until data.length()) {

        dataList.add(
            DayModel(
                data.getJSONArray(i).getString(0),
                data.getJSONArray(i).getJSONArray(1)
            )
        )
    }

    val listState = rememberLazyListState()
    LaunchedEffect(dataList.size) {
        listState.animateScrollToItem(dataList.size * 20)
    }

//    val sortedList = dataList.sortedWith(compareBy(DayModel::date))

    LazyColumn(state = listState) {

        for (i in dataList) {

            if (lastDate != i.date) {
                stickyHeader {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.DarkGray)
                            .padding(2.dp),
                        text = i.date.slice(4..5) + " " +
                                monthList.get(i.date.slice(2..3).toInt()) + " 20" +
                                i.date.slice(0..1),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
                lastDate = i.date
            }

            val itemList = mutableListOf<ItemRowModel>()
            for (ii in 0 until i.content.length()) {
                itemList.add(ItemRowModel(i.content.getJSONArray(ii).getString(0),
                    i.content.getJSONArray(ii).getString(1),
                    i.content.getJSONArray(ii).getInt(2),
                    i.content.getJSONArray(ii).getInt(3),
                    i.content.getJSONArray(ii).getString(4)))
            }
            Log.d("Valstan", "itemList - $itemList")

            itemsIndexed(itemList)
            { _, item ->
                ItemRow(ItemsRow = item, sets)
            }



        }
    }
}
