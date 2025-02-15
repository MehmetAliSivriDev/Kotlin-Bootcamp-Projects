package com.example.filmleruygulamasi.di

import com.example.filmleruygulamasi.data.dataSource.FilmlerDataSource
import com.example.filmleruygulamasi.data.repo.FilmlerRepository
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
    fun provideFilmlerDataSource() : FilmlerDataSource {
        return FilmlerDataSource()
    }

    @Provides
    @Singleton
    fun provideFilmlerRepository(fds : FilmlerDataSource) : FilmlerRepository{
        return FilmlerRepository(fds)
    }
}