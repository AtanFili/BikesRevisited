package com.gsixacademy.android.bikesrevisited.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gsixacademy.android.bikesrevisited.R
import com.gsixacademy.android.bikesrevisited.models.BikeModel
import com.gsixacademy.android.bikesrevisited.models.BikeResult
import kotlinx.android.synthetic.main.bikes_custom_row.view.*


class Adapter(
    var bikeList: ArrayList<BikeResult>,
    val bikesOnClickEvent:(BikesOnClickEvent)->Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.bikes_custom_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var myHolder = holder as MyViewHolder
        myHolder.bindData(bikeList[position], position)


    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(itemModel: BikeResult, position: Int) {
            itemView.city_TV.text = itemModel.city
            itemView.country_TV.text = itemModel.country


        }

    }

    override fun getItemCount(): Int {
        return bikeList.size
    }
}
