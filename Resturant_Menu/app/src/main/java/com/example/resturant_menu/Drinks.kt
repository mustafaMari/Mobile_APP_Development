package com.example.resturant_menu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.resturant_menu.customAdapters.MenuAdapter

class Drinks : AppCompatActivity() {
    private val drinks =
        arrayListOf<Triple<String, ArrayList<Pair<String, Int>>, Pair<String, Int>>>(
            Triple(
                "Drink 1",
                arrayListOf(),
                Pair(
                    "500",
                    R.drawable.drink1
                )
            ),
            Triple(
                "Drink 2",
                arrayListOf(),
                Pair(
                    "500",
                    R.drawable.drink2
                )
            ),
            Triple(
                "Drink 3",
                arrayListOf(),
                Pair(
                    "500",
                    R.drawable.drink3
                )
            ),
            Triple(
                "Drink 4",
                arrayListOf(),
                Pair(
                    "500",
                    R.drawable.drink4
                )
            ),
            Triple(
                "Drink 5",
                arrayListOf(),
                Pair(
                    "500",
                    R.drawable.drink5
                )
            )
        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
        val adapterArray = MenuAdapter(drinks, this)
        val lv: ListView = findViewById(R.id.id_custom_list)
        lv.adapter = adapterArray
    }
}