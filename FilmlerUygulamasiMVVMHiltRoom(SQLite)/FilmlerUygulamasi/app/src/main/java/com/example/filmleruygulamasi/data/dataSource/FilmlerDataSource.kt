package com.example.filmleruygulamasi.data.dataSource

import com.example.filmleruygulamasi.data.entity.Filmler
import com.example.filmleruygulamasi.room.FilmlerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmlerDataSource(var fDao : FilmlerDao) {
    suspend fun filmleriYukle() : List<Filmler> = withContext(Dispatchers.IO){

        return@withContext fDao.filmleriYukle()
    }
}