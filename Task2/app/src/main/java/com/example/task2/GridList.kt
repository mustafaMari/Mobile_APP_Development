package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.task2.custom.GridImageAdapter

class GridList : AppCompatActivity() {

    val positions = listOf(
        "Pos 1", "Pos 2", "Pos 3"
    )
    val values = listOf(
        "V1", "V2", "V3"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_list)
        val para : String? = intent.getStringExtra("ARG1")
        val para2 : Int = intent.getIntExtra("ARG2", 0)
        val para3 :Boolean = intent.getBooleanExtra("ARG3", true)
        Toast.makeText(this, "$para  $para2  $para3", Toast.LENGTH_SHORT).show()
        val  v:GridView = findViewById(R.id.id_grid_list)
        v.adapter = GridImageAdapter(this)
        val spinner :  Spinner = findViewById(R.id.spinner)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@GridList, "Selected: ${values[position]}", Toast.LENGTH_SHORT).show()
            }


            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@GridList, "SELECTED NADA", Toast.LENGTH_SHORT).show()
            }

        }
        val arrayAdapter : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item)
        arrayAdapter.addAll(positions)
        arrayAdapter.setDropDownViewResource(android.R.    layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter
    }
}