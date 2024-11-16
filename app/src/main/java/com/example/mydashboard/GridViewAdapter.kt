package com.example.mydashboard

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class GridViewAdapter(
    private val list: List<GridViewModal>,
    private val context: Context
) : BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var buttonImageIV: ImageView
    private lateinit var buttonTextTV: TextView

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    @Suppress("NAME_SHADOWING")
    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.gridview_item, null)
        }
        buttonImageIV = convertView!!.findViewById(R.id.buttonImageIV)
        buttonTextTV = convertView.findViewById(R.id.buttonTextTV)

        buttonImageIV.setImageResource(list[position].image)
        buttonTextTV.text = list[position].text
        return convertView
    }
}
