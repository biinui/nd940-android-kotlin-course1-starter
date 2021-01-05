package com.udacity.grocerydelivery.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.udacity.grocerydelivery.R
import com.udacity.grocerydelivery.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate( inflater
                                         , R.layout.fragment_login
                                         , container
                                         , false)

        binding.newLoginButton.setOnClickListener {
            findNavController(this).navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        binding.loginWithExistingAccountButton.setOnClickListener {
            findNavController(this).navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        return binding.root
    }

}