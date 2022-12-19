package com.example.nagrada

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nagrada.screens.MainScreen
import com.example.nagrada.models.DayModel
import com.example.nagrada.models.PersonModel
import com.example.nagrada.screens.Authorization
import com.example.nagrada.ui.theme.NagradaTheme
import org.json.JSONObject


class MainActivity : ComponentActivity() {

    @SuppressLint("CommitPrefEdits", "MutableCollectionMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NagradaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val myBASE = getSharedPreferences("BASE", Context.MODE_PRIVATE)
                    val editor = myBASE.edit()
//                    val sets = myBASE.getString("sets", "")
//                    val data = myBASE.getString("data", "")
                    val pers = myBASE.getString("person", "")


                    val monthList = listOf(
                        "пустой",
                        "января",
                        "февраля",
                        "марта",
                        "апреля",
                        "мая",
                        "июня",
                        "июля",
                        "августа",
                        "сентября",
                        "октября",
                        "ноября",
                        "декабря"
                    )
                    editor.putString("monthlist", monthList.toString())
                    editor.apply()

                    if (pers != null) {
                        Authorization()
                    }

//                    val personItem = PersonModel()
//                    "0184e741-01d6-737b-80a1-9e5ef0586826".also { personItem.token = it }
//                    "Савиных".also { personItem.family = it }
//                    "Валентин".also { personItem.name = it }
//                    ("https://sun9-13.userapi.com/impg/CcUafm8BH-evHA019kmLiEl" +
//                            "HhCcPmkiXVrpGzQ/l37RJzmQ8mI.jpg?size=484x480&" +
//                            "quality=95&sign=5ccb5d814dfd4f510bdaa4a829dd8" +
//                            "9df&type=album").also { personItem.avatar = it }
//                    "valstan".also { personItem.login = it }
//                    "nitro2000".also { personItem.password = it }

                    val person = PersonModel(
                        "Валентин",
                        "Савиных",
                        "valstan",
                        "nitro2000",
                        "https://sun9-13.userapi.com/" +
                                "impg/CcUafm8BH-evHA019kmLiElHhCcPmkiXVrpGzQ/l37RJzmQ8mI.jpg?" +
                                "size=484x480&quality=95&sign=5ccb5d814dfd4f510bdaa4a829dd89df&type=album",
                        "",
                        "",
                        "",
                        "black",
                        "0184e741-01d6-737b-80a1-9e5ef0586826"
                    )

                    editor.putString("parent", person.toString())
                    editor.apply()

//                    if (sets == "") {
//                        getDataWT(this, "sets")
//                    }

                    val setsObject = JSONObject()
                    setsObject.put("1", "рубль")
                    setsObject.put("2", "доллар")
                    setsObject.put("3", "динозаврик")
                    setsObject.put("4", "конфета")
                    setsObject.put("101", "Математика")
                    setsObject.put("102", "Русский язык")
                    setsObject.put("103", "Литература")
                    setsObject.put("104", "Английский язык")
                    setsObject.put("105", "Физ-ра")
                    setsObject.put("106", "Биология")
                    setsObject.put("107", "Химия")
                    setsObject.put("108", "Физика")
                    setsObject.put("109", "Информатика")
                    setsObject.put("110", "Помыть посуду сходить в магазин")
                    editor.putString("sets", setsObject.toString())
                    editor.apply()

//                    if (data == "") {
//                        getDataWT(this, "data")
//                    }
                    val timeShtampe = listOf(
                        "221204",
                        "221205",
                        "221206",
                        "221122",
                        "221123",
                        "221124",
                        "221005",
                        "221016",
                        "220616",
                        "220510",
                        "220126",
                        "220311",
                        "220601"
                    )

                    var dayList = mutableListOf<DayModel>()

                    for (z in timeShtampe) {

                        for (y in 1..(1..6).random()) {
                            dayList.add(
                                DayModel(
                                    z,
                                    "0",
                                    (101..110).random().toString(),
                                    (1..20).random(),
                                    (-50..20000).random(),
                                    (1..4).random().toString()
                                )
                            )
                        }
                    }

                    dayList = dayList.sortedWith(compareBy(DayModel::date)) as MutableList<DayModel>



                    val daysList = remember {
                        mutableStateOf(dayList)
                    }

                    var cash = 0

                    for (i in daysList.value) {
                        cash += i.cash
                    }

//                    // Обратно в JsonArray
//                    val sortDayList = JSONArray()
//
//                    for (z in sortedList) {
//                        val zList = JSONArray().also {
//                            it.put(z.date)
//                            it.put(z.content)
//                        }
//                        sortDayList.put(zList)
//                    }
//
//                    editor.putString("data", sortDayList.toString())
//                    editor.apply()
//
//                    val proverka = JSONArray(myBASE.getString("data", ""))
//
//                    Log.d("Valstan", "proverka - $proverka")
//
//                    list = mutableListOf()
//
//                    for (i in 0 until proverka.length()) {
//
//                        list.add(
//                            DayModel(
//                                allList.getJSONArray(i).getString(0),
//                                allList.getJSONArray(i).getJSONArray(1)
//                            )
//                        )
//                    }
//
//                    Log.d("Valstan", "list из памяти - $list")
//
////                    LoaderScreen(this)
//
                    Image(
                        painter = painterResource(id = R.drawable.bg_fon),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxSize()
                            .alpha(0.7f),
                        contentScale = ContentScale.FillBounds
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxSize(0.9f)
                            .padding(2.dp)
                    ) {
                        MainScreen(daysList, monthList, setsObject, person, cash)
                    }
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    NagradaTheme {
//        MainScreen(daysList = daysList,
//            monthList = monthList,
//            sets = setsObject,
//            person = parentList,
//            cash = cash
//        )
//    }
//}
