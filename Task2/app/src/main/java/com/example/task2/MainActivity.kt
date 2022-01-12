package com.example.task2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun openSimple(view : View){
        val navigateToSimpleList = Intent(this, SimpleList::class.java)
        startActivity(navigateToSimpleList)
    }
    fun openMultiple(view : View){
        val navigateToMultiChoiceList = Intent(this, MultiChoiceList::class.java)
        startActivityForResult(navigateToMultiChoiceList, 0)
    }
    fun openGrid(view : View){
        val navigateToGridList = Intent(this, GridList::class.java)
        navigateToGridList.putExtra("ARG1", "String")
        navigateToGridList.putExtra("ARG2", 10)
        navigateToGridList.putExtra("ARG3", false)
        startActivity(navigateToGridList)
    }
    fun openCustom(view : View){
        val navigateToCustomList = Intent(this, CustomList::class.java)
        startActivity(navigateToCustomList)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 0)
            Toast.makeText(this, "Nothing selected", Toast.LENGTH_SHORT).show()
        else
            if (data != null) {
                Toast.makeText(this, data.getStringExtra("Result"), Toast.LENGTH_SHORT).show()
            }
    }
}