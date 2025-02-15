package com.example.filmleruygulamasi.retrofit

import com.example.filmleruygulamasi.data.entity.FilmlerCevap
import retrofit2.http.GET

interface FilmlerDao {

    //http://kasimadalan.pe.hu/filmler_yeni/tum_filmler.php
    //http://kasimadalan.pe.hu/     --> Base URL
    //filmler_yeni/tum_filmler.php  --> Webservis URL

    @GET("filmler_yeni/tum_filmler.php")
    suspend fun filmleriYukle() : FilmlerCevap

}