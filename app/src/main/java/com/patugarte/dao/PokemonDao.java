package com.patugarte.dao;

import com.patugarte.model.Pokemon;
import com.patugarte.model.PokemonContainer;
import com.patugarte.servicios.PokemonService;
import com.patugarte.util.ResultListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonDao {

    private static final String BASE_URL = "https://pokeapi.co/api/v2/";
    private Retrofit retrofit;
    private PokemonService pokemonService;

    public PokemonDao() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.pokemonService = this.retrofit.create(PokemonService.class);
    }

    public void getPokemonList(final ResultListener<PokemonContainer> escuchadorDelController) {
        Call<PokemonContainer> call = this.pokemonService.getPokemonList(0,151);

        call.enqueue(new Callback<PokemonContainer>() {
            @Override
            public void onResponse(Call<PokemonContainer> call, Response<PokemonContainer> response) {
                PokemonContainer body = response.body();
                escuchadorDelController.finish(body);
            }

            @Override
            public void onFailure(Call<PokemonContainer> call, Throwable t) {
                String message = t.getMessage();
                System.out.println("Ha ocurrido un error " + message);
                t.printStackTrace();
            }
        });
    }

    public void getOnePokemonData(final ResultListener<Pokemon> escuchadorDelController,String name) {

        Call<Pokemon> call = this.pokemonService.getOnePokemonData(name);

        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon unPokemon = response.body();
                escuchadorDelController.finish(unPokemon);
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                String message = t.getMessage();
                System.out.println("Ha ocurrido un error " + message);
                t.printStackTrace();
            }
        });
    }

    /*private List<Pokemon> generarListaDePokemones() {
        List<Pokemon> listaDePokemones = new ArrayList<>();

        listaDePokemones.add(new Pokemon("Bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png", "unknown"));
        listaDePokemones.add(new Pokemon("Ivysaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png", "unknown"));
        listaDePokemones.add(new Pokemon("Venusaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png", "unknown"));
        listaDePokemones.add(new Pokemon("Charmander", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png", "unknown"));
        listaDePokemones.add(new Pokemon("Charmeleon", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png", "unknown"));
        listaDePokemones.add(new Pokemon("Charizard", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png", "unknown"));
        listaDePokemones.add(new Pokemon("Squirtle", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png", "unknown"));
        listaDePokemones.add(new Pokemon("Wartortle", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/8.png", "unknown"));
        listaDePokemones.add(new Pokemon("Blastoise", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png", "unknown"));

        return listaDePokemones;
    }*/
}

                /*List<Pokemon> pokemonList = contenedorDePokemones.getResults();
                for (Pokemon pokemon : pokemonList) {
                    Call<Pokemon> callPokemon = pokemonService.getOnePokemonData(pokemon.getNombre());
                    try {
                        Pokemon body = callPokemon.execute().body();
                        listaDePokemones.add(body);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    callPokemon.enqueue(new Callback<Pokemon>() {
                        @Override
                        public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                            Pokemon unPokemon = response.body();
                            listaDePokemones.add(unPokemon);
                        }

                        @Override
                        public void onFailure(Call<Pokemon> call, Throwable t) {
                            String message = t.getMessage();
                            System.out.println("Ha ocurrido un error " + message);
                            t.printStackTrace();
                        }
                    });
                }*/
