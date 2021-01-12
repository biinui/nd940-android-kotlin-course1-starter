package com.udacity.grocerydelivery.screens.additem

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.grocerydelivery.models.Item

class AddItemViewModel : ViewModel() {

    private var _newItem = MutableLiveData<Item>()
    val newItem: LiveData<Item>
        get() = _newItem

    init {
        _newItem.value = Item("", "", 0F, "")
    }

    fun getName(): String {
        return _newItem.value?.name.toString()
    }

    fun setName(newName: String) {
        val curName = _newItem.value?.name
        if (curName != newName) {
            _newItem.value?.name = newName
        }
    }

    fun getCompany(): String {
        return _newItem.value?.company.toString()
    }

    fun setCompany(newCompany: String) {
        val curComp = _newItem.value?.company
        if (curComp != newCompany) {
            _newItem.value?.company = newCompany
        }
    }

    fun getPrice(): String {
        return _newItem.value?.price.toString()
    }

    fun setPrice(newPrice: String) {
        val curPrice = _newItem.value?.price.toString()
        if (curPrice != newPrice) {
            if (newPrice.isNullOrEmpty()) {
                _newItem.value?.price = 0F
            } else if (newPrice.isDigitsOnly()) {
                _newItem.value?.price = newPrice.toFloat()
            } else {
                _newItem.value?.price = 0F
            }
        }
    }

    fun getDescription(): String {
        return _newItem.value?.description.toString()
    }

    fun setDescription(newDesc: String) {
        val curDesc = _newItem.value?.description
        if (curDesc != newDesc) {
            _newItem.value?.description = newDesc
        }
    }

}