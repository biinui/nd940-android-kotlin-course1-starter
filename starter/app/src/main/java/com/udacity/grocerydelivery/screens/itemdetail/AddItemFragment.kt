package com.udacity.grocerydelivery.screens.itemdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.grocerydelivery.R
import com.udacity.grocerydelivery.databinding.FragmentItemDetailBinding
import com.udacity.grocerydelivery.models.Item

class AddItemFragment : Fragment() {

    private lateinit var binding: FragmentItemDetailBinding

    private lateinit var viewModel: AddItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate( inflater
                                         , R.layout.fragment_item_detail
                                         , container
                                         , false
                                         )

        binding.itemCancelButton.setOnClickListener {
            val toGroceryList = AddItemFragmentDirections.actionItemDetailFragmentToGroceryListFragment()
            it.findNavController().navigate(toGroceryList)
        }

        binding.itemSaveButton.setOnClickListener {
            val name   : String = binding.itemNameEdit       .text.toString()
            val company: String = binding.itemCompanyEdit    .text.toString()
            val desc   : String = binding.itemDescriptionEdit.text.toString()

            val price: Float = binding.itemPriceEdit.text.toString().toFloat()

            viewModel.newItem(name, company, price, desc)
        }

        viewModel = ViewModelProvider(this).get(AddItemViewModel::class.java)
        viewModel.item.observe(viewLifecycleOwner, Observer { newItem ->
            val toGroceryListWithNewItem = AddItemFragmentDirections.actionItemDetailFragmentToGroceryListFragment(newItem)
            findNavController().navigate(toGroceryListWithNewItem)
        })

        return binding.root
    }

}