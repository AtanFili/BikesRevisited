package com.gsixacademy.android.bikesrevisited.adapters

import com.gsixacademy.android.bikesrevisited.models.BikeResult

sealed class BikesOnClickEvent {
    data class BikesClicked(val bike:BikeResult):BikesOnClickEvent()

}
