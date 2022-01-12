package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.task2.custom.CustomAdapter

class CustomList : AppCompatActivity(){
    private val titles = arrayListOf(
        "Item1",
        "Item2",
        "Item3"
    )
    private val subtitles = arrayListOf(
        "1",
        "2",
        "3"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list)
        print("Titles size" +titles.size)
        val adapterArray = CustomAdapter(titles, subtitles, this)
        val lv:ListView= findViewById(R.id.id_custom_list)
        lv.adapter = adapterArray

    }
}