package com.example.kisileruygulamasi.data.dataSource

import android.util.Log
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.retrofit.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kDao : KisilerDao) {

    suspend fun kisileriYukle() : List<Kisiler> = withContext(Dispatchers.IO){

        return@withContext kDao.kisileriYukle().kisiler
    }
    suspend fun kaydet(kisi_ad:String, kisi_tel:String){
        kDao.kaydet(kisi_ad,kisi_tel)
    }

    suspend fun guncelle(kisi_id:Int,kisi_ad:String, kisi_tel:String){
        kDao.guncelle(kisi_id,kisi_ad,kisi_tel)
    }

    suspend fun sil(kisi_id:Int){
        kDao.sil(kisi_id)
    }

    suspend fun ara(aramaKelimesi:String): List<Kisiler> = withContext(Dispatchers.IO){
        return@withContext kDao.ara(aramaKelimesi).kisiler
    }
}