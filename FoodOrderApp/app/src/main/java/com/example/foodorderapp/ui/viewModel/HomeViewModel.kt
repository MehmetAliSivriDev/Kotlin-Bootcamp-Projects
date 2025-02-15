package com.example.foodorderapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodorderapp.data.entity.FoodModel
import com.example.foodorderapp.data.repo.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var fRepo : FoodRepository) : ViewModel() {

    var foodList = MutableLiveData<List<FoodModel>>()
    var tempFoodList = MutableLiveData<List<FoodModel>>()

    init {
        getAllFoodData()
    }

    fun getAllFoodData(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                foodList.value = fRepo.getAllFoodData()
                tempFoodList.value = foodList.value
            }catch (e: Exception){
                Log.e("ServiceError", "Service Error:${e.message}")
            }
        }
    }

    fun searchFood(foodName: String) {
        tempFoodList.value?.let { list ->

            if (foodName.isBlank()) {
                tempFoodList.value = foodList.value
            } else {
                val tempList = list.filter { it.yemek_adi.lowercase().contains(foodName.lowercase()) }

                tempFoodList.value = tempList
            }
        }
    }
}