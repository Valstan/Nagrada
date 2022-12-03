package com.example.nagrada.bin

import android.content.Context
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.example.nagrada.bin.ItemRow
import com.example.nagrada.models.ItemRowModel

@Composable
fun ListItems(context: Context) {
    val myBASE = context.applicationContext.getSharedPreferences("BASE", Context.MODE_PRIVATE)
    LazyColumn() {
        itemsIndexed(
            listOf(
                ItemRowModel(
                    1,
                    "Математика там и ишо шота такое. И еще добавим",
                    5,
                    10,
                    "руб."
                ),
                ItemRowModel(2, "Русский язык", 5, 10, "руб."),
                ItemRowModel(3, "Природоведение", 2, -10, "руб."),
                ItemRowModel(8, "Математика", 4, 5, "руб."),
                ItemRowModel(8, "Физ-ра", 3, 3, "руб."),
                ItemRowModel(8, "Помыла посуду", 0, 100, "руб."),
                ItemRowModel(10, "Физра", 5, 10, "руб."),
                ItemRowModel(12, "Русский язык", 4, 523, "руб."),
                ItemRowModel(15, "Вымыла пол", 0, 150, "руб."),
                ItemRowModel(27, "Русский язык", 5, 10, "руб."),
                ItemRowModel(7, "Природоведение", 2, -10, "руб."),
                ItemRowModel(8, "Математика", 4, 5, "руб."),
                ItemRowModel(8, "Физ-ра", 3, 3, "руб."),
                ItemRowModel(8, "Литература", 5, 10, "руб."),
                ItemRowModel(5, "Физра", 5, 10, "руб."),
                ItemRowModel(7, "Русский язык", 4, 5, "руб."),
                ItemRowModel(5, "Математика и еще чего то там незнаю", 5, 10, "руб."),
                ItemRowModel(7, "Русский язык", 5, 10, "руб."),
                ItemRowModel(7, "Природоведение", 2, -10, "руб."),
                ItemRowModel(8, "Математика", 4, 5, "руб."),
                ItemRowModel(8, "Физ-ра", 3, 3, "руб."),
                ItemRowModel(8, "Литература", 5, 10, "руб."),
                ItemRowModel(5, "Физра", 5, 10, "руб."),
                ItemRowModel(7, "Русский язык", 4, 5, "руб."),
                ItemRowModel(5, "Математика и еще чего то там незнаю", 5, 10, "руб."),
                ItemRowModel(7, "Русский язык", 5, 10, "руб."),
                ItemRowModel(7, "Природоведение", 2, -10, "руб."),
                ItemRowModel(8, "Математика", 4, 5, "руб."),
                ItemRowModel(8, "Физ-ра", 3, 3, "руб."),
                ItemRowModel(8, "Литература", 5, 10, "руб."),
                ItemRowModel(5, "Физра", 5, 10, "руб."),
                ItemRowModel(7, "Русский язык", 4, 5, "руб."),
                ItemRowModel(5, "Математика и еще чего то там незнаю", 5, 10, "руб."),
                ItemRowModel(7, "Русский язык", 5, 10, "руб."),
                ItemRowModel(7, "Природоведение", 2, -10, "руб."),
                ItemRowModel(8, "Математика", 4, 5, "руб."),
                ItemRowModel(8, "Физ-ра", 3, 3, "руб."),
                ItemRowModel(8, "Литература", 5, 10, "руб."),
                ItemRowModel(5, "Физра", 5, 10, "руб."),
                ItemRowModel(7, "Русский язык", 4, 5, "руб."),
                ItemRowModel(5, "Математика и еще чего то там незнаю", 5, 10, "руб."),
                ItemRowModel(7, "Русский язык", 5, 10, "руб."),
                ItemRowModel(7, "Природоведение", 2, -10, "руб."),
                ItemRowModel(8, "Математика", 4, 5, "руб."),
                ItemRowModel(8, "Физ-ра", 3, 3, "руб."),
                ItemRowModel(8, "Литература", 5, 10, "руб."),
                ItemRowModel(5, "Физра", 5, 10, "руб."),
                ItemRowModel(7, "Русский язык", 4, 5, "руб."),

                )
        ) { _, item ->
            ItemRow(ItemRowModel = item)
        }
    }
}