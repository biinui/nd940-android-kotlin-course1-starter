package com.udacity.grocerydelivery.screens.itemdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.grocerydelivery.R
import com.udacity.grocerydelivery.databinding.FragmentItemDetailBinding
import com.udacity.grocerydelivery.models.Item

class AddItemFragment : Fragment() {

    private lateinit var binding: FragmentItemDetailBinding

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
            it.findNavController().navigate(ItemDetailFragmentDirections.actionItemDetailFragmentToGroceryListFragment())
        }

        binding.itemSaveButton.setOnClickListener {
            val name   : String = binding.itemNameEdit       .text.toString()
            val company: String = binding.itemCompanyEdit    .text.toString()
            val desc   : String = binding.itemDescriptionEdit.text.toString()

            val price: Float = binding.itemPriceEdit.text.toString().toFloat()

            val item = Item(name, company, price, desc)

            it.findNavController().navigate(ItemDetailFragmentDirections.actionItemDetailFragmentToGroceryListFragment(item))
        }

        return binding.root
    }

}