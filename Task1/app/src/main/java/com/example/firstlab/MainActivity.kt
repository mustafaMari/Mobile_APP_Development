package com.example.firstlab

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigateToNeedSpace = Intent(this, NeedSpaceButtonActivity::class.java)
        val needSpaceButton = findViewById<Button>(R.id.needSpace_Button)
        needSpaceButton.setOnClickListener(View.OnClickListener{
            startActivity(navigateToNeedSpace)
        })

    }
    fun openActivityNeedSpaceButton(view: View){
        val navigateToNeedSpace = Intent(this, NeedSpaceButtonActivity::class.java)
        startActivity(navigateToNeedSpace)
    }
    fun openActivityAnother(view: View){
        val navigateToAnother = Intent(this,AnotherActivity::class.java)
        startActivity(navigateToAnother)
    }

}