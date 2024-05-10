package com.tcf.employeeprofileapp.di

import com.tcf.employeeprofileapp.remote.ApiService
import com.tcf.employeeprofileapp.remote.repository.GeneralRepository
import com.tcf.employeeprofileapp.remote.repository.GeneralRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Singleton

@DelicateCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(apiService: ApiService):GeneralRepository{
        return GeneralRepositoryImpl(apiService)
    }
}