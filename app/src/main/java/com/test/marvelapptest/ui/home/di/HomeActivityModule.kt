package com.test.marvelapptest.ui.home.di

import com.test.data.repository.MarvelRepository
import com.test.usecase.GetCharacters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
class HomeActivityModule {

    @ViewModelScoped
    @Provides
    fun provideGetCharacter(marvelRepository: MarvelRepository): GetCharacters = GetCharacters(marvelRepository)

}