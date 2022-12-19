package com.example.nagrada.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.nagrada.models.DayModel
import com.example.nagrada.models.PersonModel
import org.json.JSONObject

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(
    daysList: MutableState<MutableList<DayModel>>,
    monthList: List<String>,
    sets: JSONObject,
    person: PersonModel,
    cash: Int
) {
//    var lastDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMdd"))
    var lastDate = "123456"
    val listState = rememberLazyListState()

    Row(
        Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(
            painter = rememberAsyncImagePainter(person.avatar),
            contentDescription = "${person.family} ${person.name}",
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


            Text(text = person.name + " " + person.family, color = Color.White)


            Row {
                Text(text = "Всего богатств: ")
                Text(text = cash.toString(), color = Color.White)
                Text(text = " руб.")
            }
        }
    }


    LaunchedEffect(daysList.value.size) {
        listState.animateScrollToItem(daysList.value.size)
    }

    LazyColumn(state = listState) {

        for (i in daysList.value) {

            if (i.date != lastDate) {

                stickyHeader {

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.DarkGray),
                        text = i.date.slice(4..5) + " " +
                                monthList[i.date.slice(2..3).toInt()] + " 20" +
                                i.date.slice(0..1),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
                lastDate = i.date
            }

            item {

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(5.dp))
                        .padding(1.dp)
                        .background(color = Color.LightGray.copy(alpha = 0.3f)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {

                    Text(
                        text = sets.get(i.text).toString(),
                        Modifier
                            .fillMaxWidth(0.65f)
                            .padding(start = 3.dp),
                        textAlign = TextAlign.Start,
                        fontSize = 20.sp
                    )
                    Text(
                        text = i.ball.toString(),
                        Modifier.fillMaxWidth(0.25f),
                        textAlign = TextAlign.Start,
                        color = Color.Red,
                        fontSize = 20.sp,
                        maxLines = 1
                    )

                    Text(
                        text = i.cash.toString(),
                        Modifier.fillMaxWidth(0.65f).padding(end = 1.dp),
                        color = Color.Yellow,
                        textAlign = TextAlign.End,
                        fontSize = 16.sp,
                        maxLines = 1
                    )
                    Text(
                        text = sets.get(i.currency).toString(),
                        fontSize = 16.sp,
                        color = Color.Black,
                        maxLines = 1
                    )
                }
            }
        }
    }
}


