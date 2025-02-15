package com.example.kisileruygulamasi.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiKayitViewModel @Inject constructor(var kRepo : KisilerRepository) : ViewModel() {

    fun kaydet(kisi_ad:String, kisi_tel:String){
        kRepo.kaydet(kisi_ad,kisi_tel)
    }
}