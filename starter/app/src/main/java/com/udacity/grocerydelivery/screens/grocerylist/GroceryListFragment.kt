package com.udacity.grocerydelivery.screens.grocerylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.grocerydelivery.R
import com.udacity.grocerydelivery.databinding.FragmentGroceryListBinding

class GroceryListFragment : Fragment() {

    private lateinit var binding: FragmentGroceryListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate( inflater
                                         , R.layout.fragment_grocery_list
                                         , container
                                         , false
                                         )

        binding.fab.setOnClickListener {
            findNavController().navigate(GroceryListFragmentDirections.actionGroceryListFragmentToItemDetailFragment())
        }

        return binding.root
    }


}