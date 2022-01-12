package com.example.resturant_menu.customAdapters

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.support.v4.content.ContextCompat.startActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.resturant_menu.Drinks
import com.example.resturant_menu.Ingredients
import com.example.resturant_menu.MainActivity
import com.example.resturant_menu.R
import java.io.Serializable

class MenuAdapter (
    private var subItems: ArrayList<Triple<String, ArrayList<Pair<String, Int>>, Pair<String, Int>>>,
    private var context: Context
    ) : BaseAdapter(){

    override fun getCount(): Int {
        return subItems.size
    }
    private val inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var menuItem = MenuItem()
        var view = convertView
        if (view == null){
            view = inflater.inflate(R.layout.row_list, null)
            menuItem.name = view.findViewById(R.id.name) as TextView
            menuItem.ingredients = view.findViewById(R.id.ingredients) as TextView
            menuItem.picture = view.findViewById(R.id.picture) as ImageView
            menuItem.price = view.findViewById(R.id.price) as TextView
            view.tag = menuItem
        }else {
            menuItem = view.tag as MenuItem
        }
        var ingredientsString = ""
        val (a, b, c) = subItems[position]
         menuItem.name.text = a
        val inNam = ArrayList<String>()
        val inSou = ArrayList<Int>()
        for (s in b){
            val (ing, sour) = s
            ingredientsString  = "$ingredientsString , $ing"
            inNam.add(ing)
            inSou.add(sour)
        }
        ingredientsString = ingredientsString.drop(3)
        menuItem.ingredients.text = ingredientsString
        val (d, e) = c
        menuItem.picture.setImageResource(e)
        menuItem.price.text = d
        menuItem.picture.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, a)
                type = "text/plain"

            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            view?.context?.startActivity(shareIntent)
        }
        menuItem.picture.setOnLongClickListener {
            Toast.makeText(context, "Long click", Toast.LENGTH_SHORT).show()
            val navigateToSimpleList =  (context, Ingredients::class.java)
            navigateToSimpleList.putExtra("NeededList names", b )
            view?.context?.startActivity(navigateToSimpleList)
            return@setOnLongClickListener true
        }
        return view as View

    }

}
class MenuItem{
    lateinit var name : TextView
    lateinit var ingredients : TextView
    lateinit var picture : ImageView
    lateinit var price : TextView
}
