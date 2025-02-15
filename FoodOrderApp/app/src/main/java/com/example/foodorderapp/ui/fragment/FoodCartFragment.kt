package com.example.foodorderapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.foodorderapp.R
import com.example.foodorderapp.databinding.FragmentFoodCartBinding
import com.example.foodorderapp.ui.adapter.CartItemAdapter
import com.example.foodorderapp.ui.viewModel.FoodCartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodCartFragment : Fragment() {

    private lateinit var binding: FragmentFoodCartBinding
    private lateinit var viewModel: FoodCartViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_food_cart,container,false)

        binding.foodCartFragment = this

        viewModel.cartItemList.observe(viewLifecycleOwner){
            val cartItemAdapter = CartItemAdapter(requireContext(),it,viewModel,binding)
            binding.cartItemAdapter = cartItemAdapter
            setTotalPrice()
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : FoodCartViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun closePage(view: View){
        Navigation.findNavController(view).popBackStack()
    }

    fun setTotalPrice(){
        viewModel.setTotalPrice(binding)
    }

}