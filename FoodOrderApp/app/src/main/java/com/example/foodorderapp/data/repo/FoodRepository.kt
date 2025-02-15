package com.example.foodorderapp.data.repo

import com.example.foodorderapp.data.dataSource.FoodDataSource
import com.example.foodorderapp.data.entity.CartItemModel
import com.example.foodorderapp.data.entity.FoodModel

class FoodRepository(var fds:FoodDataSource) {

    suspend fun getAllFoodData() : List<FoodModel> = fds.getAllFoodData()
    suspend fun getAllFoodFromCart(kullanici_adi: String) : List<CartItemModel> = fds.getAllFoodFromCart(kullanici_adi)
    suspend fun addFoodToCart(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_adet:Int,kullanici_adi:String) = fds.addFoodToCart(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
    suspend fun deleteFoodFromCart(sepet_yemek_id:Int,kullanici_adi: String) = fds.deleteFoodFromCart(sepet_yemek_id,kullanici_adi)
}