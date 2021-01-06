package com.udacity.grocerydelivery.screens.itemdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.grocerydelivery.models.Item

class AddItemViewModel : ViewModel() {

    private val _item = MutableLiveData<Item>()
    val item: LiveData<Item>
        get() = _item

    fun newItem(name: String, company: String, price: Float, description: String) {
        _item.value = Item(name, company, price, description)
    }

}