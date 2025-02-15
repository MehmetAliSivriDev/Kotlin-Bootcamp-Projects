package com.example.kisileruygulamasi.data.dataSource

import android.util.Log
import com.example.kisileruygulamasi.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource {

    suspend fun kisileriYukle() : List<Kisiler> = withContext(Dispatchers.IO){
        val kisilerListesi = ArrayList<Kisiler>()
        val ks1 = Kisiler(1,"ahmet","1111")
        val ks2 = Kisiler(2,"selin","2222")
        val ks3 = Kisiler(3,"dursun","3333")
        kisilerListesi.add(ks1)
        kisilerListesi.add(ks2)
        kisilerListesi.add(ks3)

        return@withContext kisilerListesi
    }
    suspend fun kaydet(kisi_ad:String, kisi_tel:String){
        Log.e("Kişi Kaydet","$kisi_ad - $kisi_tel")
    }

    suspend fun guncelle(kisi_id:Int,kisi_ad:String, kisi_tel:String){
        Log.e("Kişi Güncelle","$kisi_id - $kisi_ad - $kisi_tel")
    }

    suspend fun sil(kisi_id:Int){
        Log.e("Kişi Sil", "$kisi_id - Silindi")
    }

    suspend fun ara(aramaKelimesi:String): List<Kisiler> = withContext(Dispatchers.IO){
        val kisilerListesi = ArrayList<Kisiler>()
        val ks1 = Kisiler(1,"ahmet","1111")
        kisilerListesi.add(ks1)
        return@withContext kisilerListesi
    }
}