package com.patugarte.servicios;

import com.patugarte.model.Pokemon;
import com.patugarte.model.PokemonContainer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokemonService {

    @GET("pokemon/")
    Call<PokemonContainer> getPokemonList(@Query("offset") Integer offset, @Query("limit") Integer limit);

    @GET("pokemon/{name}")
    Call<Pokemon> getOnePokemonData(@Path("name") String nombre);
}
