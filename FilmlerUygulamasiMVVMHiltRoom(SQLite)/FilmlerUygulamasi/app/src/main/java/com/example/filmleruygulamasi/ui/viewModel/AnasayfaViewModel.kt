package com.example.filmleruygulamasi.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmleruygulamasi.data.entity.Filmler
import com.example.filmleruygulamasi.data.repo.FilmlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var fRepo : FilmlerRepository) : ViewModel() {
    var filmlerListesi = MutableLiveData<List<Filmler>>()

    init {
        filmleriYukle()
    }

    fun filmleriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            filmlerListesi.value = fRepo.filmleriYukle()
        }
    }
}