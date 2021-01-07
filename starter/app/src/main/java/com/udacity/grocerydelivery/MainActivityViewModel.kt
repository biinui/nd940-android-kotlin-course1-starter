package com.udacity.grocerydelivery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.grocerydelivery.models.Item
import timber.log.Timber

class MainActivityViewModel : ViewModel() {

    private val _groceryList = MutableLiveData<ArrayList<Item>>()
    val groceryList: LiveData<ArrayList<Item>>
        get() = _groceryList

    private val _newItem = MutableLiveData<Item>()
    
    init {
        _groceryList.value = ArrayList<Item>()
        _newItem.value = Item("", "", 0f, "")
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

    override fun onCleared() {
        super.onCleared()
        Timber.e("I'm cleared :(")
    }

    fun saveItem() {
        _groceryList.value?.add(_newItem.value!!)
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
            _newItem.value?.price = newPrice.toFloat()
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