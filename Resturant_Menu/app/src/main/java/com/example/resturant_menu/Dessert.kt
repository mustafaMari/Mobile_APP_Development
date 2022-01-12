package com.example.resturant_menu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.resturant_menu.customAdapters.MenuAdapter

class Dessert : AppCompatActivity() {
    private val dessert =
        arrayListOf<Triple<String, ArrayList<Pair<String, Int>>, Pair<String, Int>>>(
            Triple(
                "Dessert 1",
                arrayListOf(),
                Pair(
                    "500",
                    R.drawable.dessert1
                )
            ),
            Triple(
                "Dessert 2",
                arrayListOf(),
                Pair(
                    "500",
                    R.drawable.dessert2
                )
            ),
            Triple(
                "Dessert 3",
                arrayListOf(),
                Pair(
                    "500",
                    R.drawable.dessert3
                )
            ),
            Triple(
                "Dessert 4",
                arrayListOf(),
                Pair(
                    "500",
                    R.drawable.dessert4
                )
            ),
            Triple(
                "Dessert 5",
                arrayListOf(),
                Pair(
                    "500",
                    R.drawable.dessert5
                )
            )
        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
        val adapterArray = MenuAdapter(dessert, this)
        val lv: ListView = findViewById(R.id.id_custom_list)
        lv.adapter = adapterArray
    }
}