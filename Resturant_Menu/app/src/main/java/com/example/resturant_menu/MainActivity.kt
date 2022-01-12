package com.example.resturant_menu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun openFood(view : View){
        val navigateToSimpleList = Intent(this, Food::class.java)
        startActivity(navigateToSimpleList)
    }
    fun openDrinks(view : View){
        val navigateToSimpleList = Intent(this, Drinks::class.java)
        startActivity(navigateToSimpleList)
    }
    fun openDessert(view : View){
        val navigateToSimpleList = Intent(this, Dessert::class.java)
        startActivity(navigateToSimpleList)
    }
}