package com.example.filmleruygulamasi.di

import com.example.filmleruygulamasi.data.dataSource.FilmlerDataSource
import com.example.filmleruygulamasi.data.repo.FilmlerRepository
import com.example.filmleruygulamasi.retrofit.ApiUtils
import com.example.filmleruygulamasi.retrofit.FilmlerDao
import com.example.filmleruygulamasi.retrofit.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideFilmlerDataSource(fDao : FilmlerDao) : FilmlerDataSource {
        return FilmlerDataSource(fDao)
    }

    @Provides
    @Singleton
    fun provideFilmlerRepository(fds : FilmlerDataSource) : FilmlerRepository{
        return FilmlerRepository(fds)
    }

    @Provides
    @Singleton
    fun provideFilmlerDao() : FilmlerDao {
        return ApiUtils.getFilmlerDao()
    }
}