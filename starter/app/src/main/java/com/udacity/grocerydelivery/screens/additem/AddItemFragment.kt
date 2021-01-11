package com.udacity.grocerydelivery.screens.additem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.grocerydelivery.R
import com.udacity.grocerydelivery.databinding.FragmentAddItemBinding

class AddItemFragment : Fragment() {

    private lateinit var binding: FragmentAddItemBinding

    private lateinit var viewModel: AddItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate( inflater
                                         , R.layout.fragment_add_item
                                         , container
                                         , false
                                         )

        binding.itemCancelButton.setOnClickListener {
            val toGroceryListFragment = AddItemFragmentDirections.actionItemDetailFragmentToGroceryListFragment(null)
            findNavController().navigate(toGroceryListFragment)
        }

        viewModel = ViewModelProvider(this).get(AddItemViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        binding.itemSaveButton.setOnClickListener {
            val toGroceryListFragment = AddItemFragmentDirections.actionItemDetailFragmentToGroceryListFragment(viewModel.newItem.value)
            findNavController().navigate(toGroceryListFragment)
        }

        return binding.root
    }

}