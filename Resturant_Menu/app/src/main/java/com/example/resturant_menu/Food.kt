package com.example.resturant_menu

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.resturant_menu.customAdapters.MenuAdapter
import java.util.*
import kotlin.collections.ArrayList

class Food : AppCompatActivity() {
    private val food =
        arrayListOf<Triple<String, ArrayList<Pair<String, Int>>, Pair<String, Int>>>(
            Triple(
                "Food 1",
                arrayListOf(
                    Pair("TEST 1",R.drawable.food1),
                    Pair("TEST 2", R.drawable.food2),
                    Pair( "TEST 3", R.drawable.food3)
                ),
                Pair(
                    "500",
                    R.drawable.food1
                )
            ),
            Triple(
                "Food 2",
                arrayListOf(),
                Pair(
                    "500",
                    R.drawable.food2
                )
            ),
            Triple(
                "Food 3",
                arrayListOf(),
                Pair(
                    "500",
                    R.drawable.food3
                )
            ),
            Triple(
                "Food 4",
                arrayListOf(),
                Pair(
                    "500",
                    R.drawable.food4
                )
            ),
            Triple(
                "Food 5",
                arrayListOf(),
                Pair(
                    "500",
                    R.drawable.food3
                )
            )
        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
        val adapterArray = MenuAdapter(food, this)
        val lv: ListView = findViewById(R.id.id_custom_list)
        lv.adapter = adapterArray
    }
}