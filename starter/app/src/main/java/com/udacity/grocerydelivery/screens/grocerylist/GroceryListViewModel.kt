package com.udacity.grocerydelivery.screens.grocerylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.udacity.grocerydelivery.models.Item

class GroceryListViewModel {
    private val _groceryList = MutableLiveData<ArrayList<Item>>()
    val groceryList: LiveData<ArrayList<Item>>
        get() = _groceryList
}