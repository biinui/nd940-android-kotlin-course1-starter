package com.udacity.grocerydelivery.screens.grocerylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.grocerydelivery.models.Item
import timber.log.Timber

class GroceryListViewModel : ViewModel() {

    private val _groceryList = MutableLiveData<ArrayList<Item>>()
    val groceryList: LiveData<ArrayList<Item>>
        get() = _groceryList

    init {
        _groceryList.value = ArrayList<Item>()
        populateListWithDummyItems()
    }

    private fun populateListWithDummyItems() {
        val item1 = Item("FireJordan", "Yike", 1000f, "Cool.")
        val item2 = Item("Klawed", "NeoBalance", 800F, "Awesome.")
        val item3 = Item("DWayne", "Conserve", 500F, "Looks good.")

        _groceryList.value?.add(item1)
        _groceryList.value?.add(item2)
        _groceryList.value?.add(item3)
    }

    fun saveItem(item: Item) {
        _groceryList.value?.add(item)
    }

}