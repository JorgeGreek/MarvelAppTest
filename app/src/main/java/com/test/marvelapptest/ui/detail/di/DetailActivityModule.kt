package com.test.marvelapptest.ui.detail.di

import androidx.lifecycle.SavedStateHandle
import com.test.data.repository.MarvelRepository
import com.test.marvelapptest.ui.detail.DetailActivity
import com.test.usecase.GetDetails
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import java.lang.IllegalStateException
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
class DetailActivityModule {


    @Provides
    @Named("characterId")
    fun characterIdProvider(stateHandle: SavedStateHandle): Int =
        stateHandle.get<Int>(DetailActivity.CHARACTER_ID)
            ?: throw IllegalStateException("character id not found in the state handle")


    @ViewModelScoped
    @Provides
    fun provideGetDetails(marvelRepository: MarvelRepository): GetDetails = GetDetails(marvelRepository)

}