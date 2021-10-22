package com.test.marvelapptest.di

import com.test.data.repository.MarvelRepository
import com.test.data.source.CredentialsDataSource
import com.test.marvelapptest.server.MarvelCredentialDataSource
import com.test.marvelapptest.server.TheMarvelDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class  DataModule {

    @Singleton
    @Provides
    fun repositoryProvider(
        remoteDataSource: TheMarvelDataSource
    ): MarvelRepository = MarvelRepository(remoteDataSource)

}