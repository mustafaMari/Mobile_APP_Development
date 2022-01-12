package com.example.task2

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.view.View
import android.widget.*
import androidx.appcompat.view.menu.MenuView
import androidx.core.util.forEach
import androidx.core.util.size
import androidx.core.view.iterator

class MultiChoiceList : AppCompatActivity(), AdapterView.OnItemClickListener{
    val list2 = listOf(
        "Item1",
        "Item2",
        "Item3"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_choice_list)
        setResult(0)
        var arr =ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice)
        arr.addAll(list2)
        var lv:ListView= findViewById(R.id.id_multiChoice_list)
        lv.adapter = arr
        lv.onItemClickListener = this


    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var info:String = "Checked: "
       (findViewById<ListView>(R.id.id_multiChoice_list)).checkedItemPositions.forEach { key, value ->
           if (value)
               info = "$info, ${list2[key]}"
           else
               if (info.contains(list2[key]))
                   info.replace("${list2[key]},", "")
       }
        intent.putExtra("Result", info)
        setResult(1, intent)
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show()
    }
}