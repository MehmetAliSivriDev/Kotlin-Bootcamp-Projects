package com.example.foodorderapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.foodorderapp.R
import com.example.foodorderapp.data.entity.FoodModel
import com.example.foodorderapp.databinding.FragmentFoodOrderBinding
import com.example.foodorderapp.ui.constant.User
import com.example.foodorderapp.ui.viewModel.FoodOrderViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodOrderFragment : Fragment() {

    private lateinit var binding:FragmentFoodOrderBinding
    private lateinit var viewModel:FoodOrderViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_food_order,container,false)

        binding.foodOrderFragment = this

        val bundle : FoodOrderFragmentArgs by navArgs()
        val foodModel = bundle.foodModel
        binding.foodModel = foodModel

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${foodModel.yemek_resim_adi}"
        Glide.with(this).load(url).override(500,750).into(binding.ivFoodImage)

        setTotalPrice(foodModel.yemek_fiyat, 1)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : FoodOrderViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun closePage(view: View){
        Navigation.findNavController(view).popBackStack()
    }

    fun setTotalPrice(price:Int, count:Int){
        viewModel.setTotalPrice(binding,price,count)

    }

    fun increaseOrderCount(foodModel: FoodModel){
        viewModel.increaseOrderCount(binding,foodModel)
    }

    fun decreaseOrderCount(foodModel: FoodModel){
       viewModel.decreaseOrderCount(binding,foodModel)
    }

    fun addOrderToCart(foodModel: FoodModel, view: View){
        viewModel.addFoodToCart(foodModel.yemek_adi,foodModel.yemek_resim_adi,foodModel.yemek_fiyat,binding.tvCount.text.toString().toInt(),User.user)
        Toast.makeText(context,"Sepete Eklendi!",Toast.LENGTH_SHORT).show()
        Navigation.findNavController(view).popBackStack()
    }
}