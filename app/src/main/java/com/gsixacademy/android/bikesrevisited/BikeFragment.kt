package com.gsixacademy.android.bikesrevisited

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.gsixacademy.android.bikesrevisited.adapters.Adapter
import com.gsixacademy.android.bikesrevisited.api.ApiServiceBuilder
import com.gsixacademy.android.bikesrevisited.api.BikesApi
import com.gsixacademy.android.bikesrevisited.models.BikeModel
import com.gsixacademy.android.bikesrevisited.models.BikeResult
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BikeFragment:Fragment() {
    var bikeList=ArrayList<BikeResult>()
    var request=ApiServiceBuilder.buildService(BikesApi::class.java)
    lateinit var bikelistAdapter:Adapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.activity_main,container,false)
        val call=request.getBikes()
        call.enqueue(object :Callback<BikeModel>{


            override fun onResponse(call: Call<BikeModel>, response: Response<BikeModel>) {
             if (response.isSuccessful){
                 var bikeResponse=response.body()
                 var bikeList=bikeResponse?.results
                 if (bikeList!=null){
                     var bikelistAdapter=Adapter(bikeList){

                     }
                     recycler_view.layoutManager=LinearLayoutManager(context)
                     recycler_view.adapter=bikelistAdapter

                 }
             }

else{}


            }

            override fun onFailure(call: Call<BikeModel>, t: Throwable) {
                Toast.makeText(activity,t.message, Toast.LENGTH_SHORT)
                    .show()
            }

        })




            return view

    }



}