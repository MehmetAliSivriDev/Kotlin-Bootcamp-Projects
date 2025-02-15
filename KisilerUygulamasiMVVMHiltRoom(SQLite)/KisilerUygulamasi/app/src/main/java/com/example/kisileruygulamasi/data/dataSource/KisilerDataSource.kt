package com.example.kisileruygulamasi.data.dataSource

import android.util.Log
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.room.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kDao : KisilerDao) {

    suspend fun kisileriYukle() : List<Kisiler> = withContext(Dispatchers.IO){

        return@withContext kDao.kisileriYukle()
    }
    suspend fun kaydet(kisi_ad:String, kisi_tel:String){
        val yeni_kisi = Kisiler(0,kisi_ad,kisi_tel)

        kDao.kaydet(yeni_kisi)
    }

    suspend fun guncelle(kisi_id:Int,kisi_ad:String, kisi_tel:String){
        val guncellenen_kisi = Kisiler(kisi_id,kisi_ad,kisi_tel)

        kDao.guncelle(guncellenen_kisi)
    }

    suspend fun sil(kisi_id:Int){
        val silinen_kisi = Kisiler(kisi_id,"","")

        kDao.sil(silinen_kisi)
    }

    suspend fun ara(aramaKelimesi:String): List<Kisiler> = withContext(Dispatchers.IO){
        return@withContext kDao.ara(aramaKelimesi)
    }
}