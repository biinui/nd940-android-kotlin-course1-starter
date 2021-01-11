package com.udacity.grocerydelivery.screens.grocerylist

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.grocerydelivery.R
import com.udacity.grocerydelivery.databinding.FragmentGroceryListBinding
import com.udacity.grocerydelivery.databinding.RowItemBinding

class GroceryListFragment : Fragment() {

    private lateinit var binding: FragmentGroceryListBinding

    private lateinit var viewModel: GroceryListViewModel

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

        viewModel = ViewModelProvider(requireActivity()).get(GroceryListViewModel::class.java)
        val groceryListFragmentArgs by navArgs<GroceryListFragmentArgs>()
        groceryListFragmentArgs.newItem?.let { viewModel.saveItem(it) }

        binding.fab.setOnClickListener {
            findNavController().navigate(GroceryListFragmentDirections.actionGroceryListFragmentToItemDetailFragment())
        }

        displayRows(inflater, container)
        setHasOptionsMenu(true)

        return binding.root
    }

    private fun displayRows(inflater: LayoutInflater, container: ViewGroup?) {
        for (item in viewModel.groceryList.value!!) {
            val rowItemBinding: RowItemBinding = DataBindingUtil.inflate(inflater, R.layout.row_item, container, false)
            rowItemBinding.apply {
                rowItemName       .text = item.name
                rowItemCompany    .text = item.company
                rowItemDescription.text = item.description
                rowItemPrice      .text = item.price.toString()
            }
            binding.groceryListLayout.addView(rowItemBinding.rowItem)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.loginFragment -> {
                findNavController().navigate(GroceryListFragmentDirections.actionGroceryListFragmentToLoginFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}