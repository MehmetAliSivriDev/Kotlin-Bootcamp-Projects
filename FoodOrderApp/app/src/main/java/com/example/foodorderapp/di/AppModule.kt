package com.example.foodorderapp.di

import com.example.foodorderapp.data.dataSource.FoodDataSource
import com.example.foodorderapp.data.repo.FoodRepository
import com.example.foodorderapp.retrofit.ApiUtils
import com.example.foodorderapp.retrofit.FoodDao
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
    fun provideFoodDataSource(fDao: FoodDao) : FoodDataSource{
        return FoodDataSource(fDao)
    }

    @Provides
    @Singleton
    fun provideFoodRepository(fds:FoodDataSource) : FoodRepository{
        return FoodRepository(fds)
    }

    @Provides
    @Singleton
    fun provideFoodDao() : FoodDao{
        return ApiUtils.getFoodDao()
    }
}