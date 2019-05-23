package com.example.list.Adapter

/**
 * Created by santosh on 12/5/17.
 */

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.list.Model.Food_Model
import com.example.list.R
import kotlinx.android.synthetic.main.food_list_row.view.*


//1. custom layout = layout file renders a single row in recycler view
//2. Model= define individual items
//3. Adapter = to render the data
//4. where to look for data => pass paramater as array list of model
//5. create ViewHolder class for adapter



//your adapter and the required methods are defined using your ViewHolder class


class Food_Adapter(context: Context,private val Food: ArrayList<Food_Model>
) : RecyclerView.Adapter<Food_Adapter.ViewHodler>() {

    private val mContext: Context

    init {
        mContext = context
    }
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): Food_Adapter.ViewHodler {
        val food_row = LayoutInflater.from(mContext).inflate(R.layout.food_list_row,parent,false)
        return ViewHodler(food_row)
    }

    override fun getItemCount(): Int {
        return Food.size
    }

    override fun onBindViewHolder(holder: Food_Adapter.ViewHodler, position: Int) {

        val model = Food[position]
        holder.foodName!!.text = model.foodName

    }

    inner class ViewHodler(v : View) : RecyclerView.ViewHolder(v) {

        val foodName = v.foodName

    }
}