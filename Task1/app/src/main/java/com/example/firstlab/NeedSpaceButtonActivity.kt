package com.example.firstlab

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class NeedSpaceButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_need_space_button)
        val pnhText = findViewById<TextView>(R.id.pnh_Text)
        pnhText.setOnLongClickListener(View.OnLongClickListener{
            finish()
            false
        })
    }
}