package com.example.list.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.list.Adapter.Food_Adapter
import com.example.list.R
import android.support.v7.widget.RecyclerView
import com.example.list.Model.Food_Model
import java.util.ArrayList
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Adapter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        food_listview = findViewById<View>(R.id.Food) as RecyclerView
        food_listview.layoutManager = LinearLayoutManager(this)

        adapter = Food_Adapter(this@MainActivity, foodList)
        food_listview.adapter = adapter// set adapter

        prepareFoodData()
    }


    companion object {
        lateinit var food_listview: RecyclerView
        var foodList = ArrayList<Food_Model>()
        private  var adapter: Food_Adapter? = null

    }


    private fun prepareFoodData() {
        foodList.add( Food_Model("1", "Pizza"))
        foodList.add( Food_Model("2", "Momo"))
        foodList.add( Food_Model("3", "Chaowmin"))
        foodList.add( Food_Model("4", "Samosa"))
        foodList.add( Food_Model("5", "Aalu Stick"))
        foodList.add( Food_Model("6", "Burger"))

        adapter!!.notifyDataSetChanged()
    }
}
