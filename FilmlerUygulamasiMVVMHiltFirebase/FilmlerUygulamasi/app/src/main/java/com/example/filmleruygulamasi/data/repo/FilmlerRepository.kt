package com.example.filmleruygulamasi.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.filmleruygulamasi.data.dataSource.FilmlerDataSource
import com.example.filmleruygulamasi.data.entity.Filmler

class FilmlerRepository(var fds : FilmlerDataSource) {

    fun filmleriYukle() : MutableLiveData<List<Filmler>> = fds.filmleriYukle()
}