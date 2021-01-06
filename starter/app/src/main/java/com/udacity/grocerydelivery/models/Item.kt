package com.udacity.grocerydelivery.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item( var name: String
               , var company: String
               , var price: Float
               , var description: String
               , val images: List<String> = mutableListOf()
               ) : Parcelable