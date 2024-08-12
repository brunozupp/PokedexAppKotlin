package com.novelitech.pokedexappkotlin.repository

import com.novelitech.pokedexappkotlin.data.remote.PokeApi
import com.novelitech.pokedexappkotlin.data.remote.responses.Pokemon
import com.novelitech.pokedexappkotlin.data.remote.responses.PokemonList
import com.novelitech.pokedexappkotlin.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

/**
 * The right thing to do is create an interface
 */
@ActivityScoped // It will be injected in my viewmodel and live the same lifecycle as my activity. The case of this project, I only have ONE activity
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {

    suspend fun getPokemonList(
        limit: Int,
        offset: Int,
    ) : Resource<PokemonList> {

        val response = try {
            api.getPokemonList(
                limit = limit,
                offset = offset,
            )
        } catch(e: Exception) {
            return Resource.Error("An error occurred to get pokemon list")
        }

        return Resource.Success(data = response)
    }

    suspend fun getPokemonInfo(
        pokemonName: String,
    ) : Resource<Pokemon> {

        val response = try {
            api.getPokemonInfo(
                name = pokemonName
            )
        } catch(e: Exception) {
            return Resource.Error("An error occurred to get pokemon information")
        }

        return Resource.Success(data = response)
    }
}