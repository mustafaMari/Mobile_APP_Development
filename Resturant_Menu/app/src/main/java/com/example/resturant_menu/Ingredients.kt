package com.example.resturant_menu

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import com.example.resturant_menu.customAdapters.IngredientsAdapter
import com.example.resturant_menu.customAdapters.MenuAdapter

class Ingredients : AppCompatActivity() {
    private  var ingredients : ArrayList<Pair<String, Int>> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)
        ingredients = intent.extras?.getSerializable("NeededList names") as ArrayList<Pair<String,Int>>
        if (ingredients.isNotEmpty()){
            val adapterArray = IngredientsAdapter(ingredients, this)

            val lv: ListView = findViewById(R.id.id_custom_list)
            lv.adapter = adapterArray
        }
    }
}
