package com.example.foodorderapp.data.dataSource

import com.example.foodorderapp.data.entity.CartItemModel
import com.example.foodorderapp.data.entity.FoodModel
import com.example.foodorderapp.data.entity.ResponseFoodModel
import com.example.foodorderapp.retrofit.FoodDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodDataSource(var fDao : FoodDao){

    suspend fun getAllFoodData() : List<FoodModel> = withContext(Dispatchers.IO){
        return@withContext fDao.getAllFoodData().yemekler
    }

    suspend fun getAllFoodFromCart(kullanici_adi: String) : List<CartItemModel> = withContext(Dispatchers.IO){
        return@withContext fDao.getAllFoodFromCart(kullanici_adi).sepet_yemekler
    }

    suspend fun addFoodToCart(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int, yemek_siparis_adet:Int,kullanici_adi:String){
        fDao.addFoodToCart(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
    }

    suspend fun deleteFoodFromCart(sepet_yemek_id:Int,kullanici_adi: String){
        fDao.deleteFoodFromCart(sepet_yemek_id,kullanici_adi)
    }

}