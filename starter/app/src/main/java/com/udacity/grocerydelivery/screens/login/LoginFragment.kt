package com.udacity.grocerydelivery.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavAction
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.udacity.grocerydelivery.R
import com.udacity.grocerydelivery.databinding.FragmentLoginBinding
import com.udacity.grocerydelivery.screens.welcome.WelcomeFragmentDirections

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