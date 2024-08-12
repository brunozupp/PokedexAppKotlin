package com.novelitech.pokedexappkotlin.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class) // ALL the dependencies inside this module will be singleton
object AppModule {
}