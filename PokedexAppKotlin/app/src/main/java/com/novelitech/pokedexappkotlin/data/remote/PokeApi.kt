package com.novelitech.pokedexappkotlin.data.remote

import com.novelitech.pokedexappkotlin.data.remote.responses.Pokemon
import com.novelitech.pokedexappkotlin.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * To work with Retrofit
 * Creates this interface that will hold the functions which I will access the routes from the API
 */
interface PokeApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ) : PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String,
    ): Pokemon
}