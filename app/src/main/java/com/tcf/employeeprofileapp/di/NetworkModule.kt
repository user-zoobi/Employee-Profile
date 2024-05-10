package com.tcf.employeeprofileapp.di

import com.tcf.employeeprofileapp.remote.ApiService
import com.tcf.employeeprofileapp.remote.Routes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

class NetworkModule {

    @Module
    @InstallIn(SingletonComponent::class)
    class RepositoryModule{

        @Singleton
        @Provides
        fun provideRetrofit(): Retrofit {
            var retrofit: Retrofit? = null
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(Routes.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }

        @Singleton
        @Provides
        fun provideAppServices(retrofit: Retrofit): ApiService {
            return retrofit.create(ApiService::class.java)
        }
    }

}