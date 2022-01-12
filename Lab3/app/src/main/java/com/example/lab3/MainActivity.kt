package com.example.lab3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(m: Menu) : Boolean{
        val checkableItem : MenuItem = m.add("Item 1")
        checkableItem.isCheckable = true
        m.add("Item 2")
        m.add(0,1,Menu.NONE, "Id Item 1")
        m.add (0, 2, Menu.NONE, "Id Item 2")
        val sm : SubMenu = m.addSubMenu(0,3,Menu.NONE,"SubMenu")
        sm.add(0,4,0,"SubMenu Item 1")
        sm.add(0,5,0,"SubMenu Item 2")
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            1 -> {
                startActivity(Intent(applicationContext, XMLMenu::class.java))
                true
            }
            else -> {
                Toast.makeText(applicationContext, "${item.title} ${item.itemId}", Toast.LENGTH_SHORT).show()
                true
            }

        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v.id == R.id.firstString){
            menu.add(0,0,Menu.NONE, "Item 1")
            menu.add(0,1,Menu.NONE, "Item 2")
        }else {
            menu.add(0,2,Menu.NONE, "Item 3")
            menu.add(0,3,Menu.NONE, "Item 4")
        }
    }

//    override fun onContextItemSelected(item: MenuItem): Boolean {
//        return when(item.itemId){
//            3 -> {
//                startActivity(Intent(applicationContext, XMLMenu::class.java))
//                true
//            }
//            else -> {
//                Toast.makeText(applicationContext, "${item.title} ${item.itemId}", Toast.LENGTH_SHORT).show()
//                true
//            }
//
//        }
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerForContextMenu(findViewById(R.id.firstString))
        registerForContextMenu(findViewById(R.id.secondString))

    }
    fun openActionMode(v : View){
        startActionMode(ActionMode.Callback)
    }

}