package com.star.listviewtest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FruitAdapter(context: Context, private val resource: Int, objects: List<Fruit>) :
    ArrayAdapter<Fruit>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = convertView
            ?: LayoutInflater.from(context).inflate(resource, parent, false)
        if (view.tag == null) {
            val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
            val fruitName: TextView = view.findViewById(R.id.fruitName)
            view.tag = ViewHolder(fruitImage, fruitName)
        }
        val viewHolder = view.tag as ViewHolder

        val fruit = getItem(position)

        fruit?.apply {
            viewHolder.fruitImage.setImageResource(imageId)
            viewHolder.fruitName.text = name
        }

        return view
    }

    class ViewHolder(val fruitImage: ImageView, val fruitName: TextView)
}