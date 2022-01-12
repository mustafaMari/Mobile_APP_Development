package com.example.lab3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class XMLMenu : AppCompatActivity() {
    override fun onCreateOptionsMenu(m: Menu) : Boolean{
        menuInflater.inflate(R.menu.firstmenu, m)
        return true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xmlmenu)
    }
}