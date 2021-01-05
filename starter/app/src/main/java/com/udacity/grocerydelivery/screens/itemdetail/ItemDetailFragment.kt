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

class ItemDetailFragment : Fragment() {

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

        return binding.root
    }

}