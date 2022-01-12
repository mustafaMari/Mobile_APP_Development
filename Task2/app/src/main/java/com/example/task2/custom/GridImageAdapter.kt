package com.example.task2.custom

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.task2.R

class GridImageAdapter constructor(context: Context) : BaseAdapter() {
    private val ctx = context

    private val food = listOf(
        R.drawable.yabraque, R.drawable.kubbah, R.drawable.safiah,
        R.drawable.safiah, R.drawable.kubbah, R.drawable.yabraque,
        R.drawable.yabraque, R.drawable.safiah, R.drawable.kubbah
    )
    override fun getCount(): Int {
        return  food.size
    }

    override fun getItem(position: Int): Any {
        return food[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val v : ImageView?
        if (convertView == null){
            v = ImageView(ctx)
            v.layoutParams = ViewGroup.LayoutParams(200, 200)
            v.scaleType = ImageView.ScaleType.CENTER_CROP
            v.setPadding(8, 8, 8, 8)

        }else{
            v = convertView as ImageView
        }
        v.setImageResource(food[position])
        return v
    }
}