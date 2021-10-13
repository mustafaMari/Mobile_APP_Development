package com.example.firstlab

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast

class AnotherActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)
    }
    fun openActivityMain(view: View){
        val navigateToMain = Intent(this, MainActivity::class.java)
        startActivity(navigateToMain)
    }

    override fun onStop() {
        Toast.makeText(applicationContext, "Another Activity is stopped", Toast.LENGTH_SHORT).show()
        super.onStop()
    }
}