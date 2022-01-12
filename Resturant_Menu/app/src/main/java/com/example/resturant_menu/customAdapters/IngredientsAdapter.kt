package com.example.resturant_menu.customAdapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.resturant_menu.R

class IngredientsAdapter constructor(
    private var  ingredients : ArrayList<Pair<String, Int>>,
    context: Context
    ) : BaseAdapter(){

    override fun getCount(): Int {
        return ingredients.size
    }
    private val inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getItem(position: Int): Any {
        return ingredients[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var ingredientItem = IngredientItem()
        var view = convertView
        if (view == null){
            view = inflater.inflate(R.layout.ingredient_row_list, null)
            ingredientItem.ingredientName = view.findViewById(R.id.ingredients_name) as TextView
            ingredientItem.ingredientPicture = view.findViewById(R.id.ingredient_picture) as ImageView

            view.tag = ingredientItem
        }else {
            ingredientItem = view.tag as IngredientItem
        }
        val (a,b) = ingredients[position]
        ingredientItem.ingredientName.text = a
        ingredientItem.ingredientPicture.setImageResource(b)
        return view as View
    }

}
class IngredientItem{
    lateinit var ingredientName : TextView
    lateinit var ingredientPicture : ImageView
}