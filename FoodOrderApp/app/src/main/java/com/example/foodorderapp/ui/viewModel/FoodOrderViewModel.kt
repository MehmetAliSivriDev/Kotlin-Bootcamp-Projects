package com.example.foodorderapp.ui.viewModel

import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.foodorderapp.data.entity.FoodModel
import com.example.foodorderapp.data.repo.FoodRepository
import com.example.foodorderapp.databinding.FragmentFoodOrderBinding
import com.example.foodorderapp.ui.constant.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodOrderViewModel @Inject constructor(var fRepo : FoodRepository) : ViewModel() {

    fun addFoodToCart(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_adet:Int,kullanici_adi:String){
        CoroutineScope(Dispatchers.Main).launch {
            fRepo.addFoodToCart(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
        }
    }

    fun setTotalPrice(binding: FragmentFoodOrderBinding,price:Int, count:Int){
        var total = price * count
        binding.tvTotalFOPrice.text = "${total} ₺"

    }

    fun increaseOrderCount(binding: FragmentFoodOrderBinding,foodModel: FoodModel){
        var currentCount =  binding.tvCount.text.toString()
        var newCount = (currentCount.toInt() + 1).toString()
        binding.tvCount.text = newCount
        setTotalPrice(binding,foodModel.yemek_fiyat, newCount.toInt())
    }

    fun decreaseOrderCount(binding: FragmentFoodOrderBinding, foodModel: FoodModel){
        var currentCount =  binding.tvCount.text.toString()
        if(currentCount.toInt() > 1){
            var newCount = (currentCount.toInt() - 1).toString()
            binding.tvCount.text = newCount
            setTotalPrice(binding,foodModel.yemek_fiyat, newCount.toInt())
        }
    }

}