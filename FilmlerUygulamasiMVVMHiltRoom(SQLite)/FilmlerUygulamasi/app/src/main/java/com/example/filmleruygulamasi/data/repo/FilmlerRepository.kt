package com.example.filmleruygulamasi.data.repo

import com.example.filmleruygulamasi.data.dataSource.FilmlerDataSource
import com.example.filmleruygulamasi.data.entity.Filmler

class FilmlerRepository(var fds : FilmlerDataSource) {

    suspend fun filmleriYukle() : List<Filmler> = fds.filmleriYukle()
}