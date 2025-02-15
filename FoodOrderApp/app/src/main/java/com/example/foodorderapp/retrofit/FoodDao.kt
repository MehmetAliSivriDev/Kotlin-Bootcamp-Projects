package com.example.foodorderapp.retrofit
import com.example.foodorderapp.data.entity.CrudResultModel
import com.example.foodorderapp.data.entity.FoodModel
import com.example.foodorderapp.data.entity.ResponseCartItemModel
import com.example.foodorderapp.data.entity.ResponseFoodModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodDao {

    // http://kasimadalan.pe.hu/            --> BASE URL
    //yemekler/tumYemekleriGetir.php        --> Tüm Yemekleri Getir
    //yemekler/sepettekiYemekleriGetir.php  --> Sepetteki Yemekleri Getir
    //yemekler/sepeteYemekEkle.php          --> Sepete Yemek Ekleme
    //yemekler/sepettenYemekSil.php         --> Sepetten Yemek Silme

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun getAllFoodData() : ResponseFoodModel

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun getAllFoodFromCart(@Field("kullanici_adi") kullanici_adi: String) : ResponseCartItemModel

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun addFoodToCart(@Field("yemek_adi") yemek_adi:String,
                              @Field("yemek_resim_adi") yemek_resim_adi:String,
                              @Field("yemek_fiyat") yemek_fiyat:Int,
                              @Field("yemek_siparis_adet") yemek_siparis_adet:Int,
                              @Field("kullanici_adi") kullanici_adi:String, ) : CrudResultModel

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun deleteFoodFromCart(@Field("sepet_yemek_id") sepet_yemek_id: Int, @Field("kullanici_adi") kullanici_adi: String) : CrudResultModel
}