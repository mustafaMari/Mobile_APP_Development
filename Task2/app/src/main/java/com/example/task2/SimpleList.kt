package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class SimpleList : AppCompatActivity(), AdapterView.OnItemClickListener{
    val list = listOf(
        "Item1",
        "Item2",
        "Item3"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_list)

        var arr =ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        arr.addAll(list)
        var lv:ListView= findViewById(R.id.id_simple_list)
        lv.adapter = arr
        lv.onItemClickListener = this


    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this, list[position], Toast.LENGTH_SHORT).show()
    }
}