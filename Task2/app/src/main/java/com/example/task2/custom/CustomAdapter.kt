package com.example.task2.custom
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.task2.R

class CustomAdapter(
    private var titles: ArrayList<String>,
    private var subtitles: ArrayList<String>,
    private var context: Context
) : BaseAdapter() {
    private val inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private var checked = ArrayList<Boolean>()


    override fun getCount(): Int {
        return titles.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var item  = Item()
        var view = convertView
        if (view == null){
            for (i in 1..titles.size){
                checked.add(false)
            }
            view = inflater.inflate(R.layout.list_row, null)
            item.checkBox = view.findViewById(R.id.checkBox) as CheckBox
            item.image = view.findViewById(R.id.image) as ImageView
            item.title = view.findViewById(R.id.title) as TextView
            item.subtitle = view.findViewById(R.id.sub_title) as TextView
            view.tag = item
        }else{
            item = view.tag as Item
        }
        item.title.text = titles[position]
        item.subtitle.text = subtitles[position]
        item.checkBox.setOnClickListener{
            checked[position] = item.checkBox.isChecked
            Toast.makeText(context, "CheckBox is clicked", Toast.LENGTH_SHORT).show()
        }
        item.checkBox.isChecked = checked[position]

        return view as View
    }



}
class Item {
    lateinit var title : TextView
    lateinit var subtitle : TextView
    lateinit var image : ImageView
    lateinit var checkBox : CheckBox
}