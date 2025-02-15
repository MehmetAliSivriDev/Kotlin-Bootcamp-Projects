package com.example.kisileruygulamasi.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KisiDetayViewModel @Inject constructor(var kRepo : KisilerRepository) : ViewModel() {

    fun guncelle(kisi_id:String,kisi_ad:String, kisi_tel:String){
        kRepo.guncelle(kisi_id,kisi_ad,kisi_tel)
    }
}