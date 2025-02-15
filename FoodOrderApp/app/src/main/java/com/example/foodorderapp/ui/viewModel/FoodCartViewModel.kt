package com.example.foodorderapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodorderapp.data.entity.CartItemModel
import com.example.foodorderapp.data.repo.FoodRepository
import com.example.foodorderapp.databinding.FragmentFoodCartBinding
import com.example.foodorderapp.ui.constant.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodCartViewModel @Inject constructor(var fRepo : FoodRepository) : ViewModel() {

    var cartItemList = MutableLiveData<List<CartItemModel>>()

    init {
        getAllFoodFromCart()
    }

    fun getAllFoodFromCart(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val cartItems = fRepo.getAllFoodFromCart(User.user)
                val mergedCartItems = mutableListOf<CartItemModel>()
                val groupedItems = cartItems.groupBy { it.yemek_adi }

                groupedItems.forEach { (id, items) ->
                    val totalCount = items.sumOf { it.yemek_siparis_adet }

                    val updatedItem = items.first().apply {
                        yemek_siparis_adet = totalCount
                    }

                    mergedCartItems.add(updatedItem)
                }

                cartItemList.value = mergedCartItems
            }catch (e:Exception){
                Log.e("ServiceError", "Service Error:${e.message}")
            }
        }
    }

    fun setTotalPrice(binding: FragmentFoodCartBinding){
        cartItemList.value?.let { list ->
            var total = 0

            for(item in list){
                total += item.yemek_fiyat * item.yemek_siparis_adet
            }

            binding.tvTotalFCPrice.text = "${total} ₺"
        }
    }

    fun deleteFoodFromCart(binding: FragmentFoodCartBinding,foodName: String){
        CoroutineScope(Dispatchers.Main).launch{
            try {
                val cartItems = fRepo.getAllFoodFromCart(User.user)

                val itemsToDelete = cartItems.filter { it.yemek_adi.equals(foodName, ignoreCase = true) }

                val idsToDelete = itemsToDelete.map { it.sepet_yemek_id }

                for (id in idsToDelete) {
                    fRepo.deleteFoodFromCart(id, User.user)
                }

                getAllFoodFromCart()
                setTotalPrice(binding)
            }catch (e:Exception){
                Log.e("ServiceError", "Service Error:${e.message}")
            }


        }
    }

}