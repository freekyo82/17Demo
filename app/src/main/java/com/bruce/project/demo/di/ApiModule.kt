package com.bruce.project.demo.di

import com.bruce.project.demo.api.GitApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Reusable
    @Provides
    fun provideGitApi(retrofit: Retrofit): GitApi =
        retrofit.create(GitApi::class.java)
}