package com.udacity.grocerydelivery.screens.grocerylist

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.grocerydelivery.MainActivityViewModel
import com.udacity.grocerydelivery.R
import com.udacity.grocerydelivery.databinding.FragmentGroceryListBinding
import kotlinx.android.synthetic.main.row_item.view.*

class GroceryListFragment : Fragment() {

    private lateinit var binding: FragmentGroceryListBinding

    private lateinit var viewModel: MainActivityViewModel

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

        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
        val groceryListFragmentArgs by navArgs<GroceryListFragmentArgs>()
        groceryListFragmentArgs.newItem?.let { viewModel.addItemToList(it) }

        binding.fab.setOnClickListener {
            findNavController().navigate(GroceryListFragmentDirections.actionGroceryListFragmentToItemDetailFragment())
        }

        updateUI()
        setHasOptionsMenu(true)

        return binding.root
    }

    private fun updateUI() {
        for (item in viewModel.groceryList.value!!) {
            val rowItemView: View = View.inflate(this.context, R.layout.row_item, null)
            rowItemView.apply {
                row_item_name       .text = item.name
                row_item_company    .text = item.company
                row_item_description.text = item.description
                row_item_price      .text = item.price.toString()
            }
            binding.groceryListLayout.addView(rowItemView)
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