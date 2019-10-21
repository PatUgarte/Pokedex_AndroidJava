package com.patugarte.controller;

import com.patugarte.dao.PokemonDao;
import com.patugarte.model.Pokemon;
import com.patugarte.model.PokemonContainer;
import com.patugarte.util.ResultListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokemonController {

    private PokemonDao pokemonDao = new PokemonDao();
    private List<Pokemon> pokemonList = new ArrayList<>();

    public void obtenerPokemones(final ResultListener<List<Pokemon>> escuchadorDeLaVista) {
        pokemonDao.getPokemonList(new ResultListener<PokemonContainer>() {
            @Override
            public void finish(PokemonContainer resultadoContainer) {
                List<Pokemon> results = resultadoContainer.getResults();
                for (final Pokemon pokemon : results) {
                    String nombrePokemon = pokemon.getNombre();
                    pokemonDao.getOnePokemonData(new ResultListener<Pokemon>() {
                        @Override
                        public void finish(Pokemon resultadoPokemon) {
                            pokemonList.add(resultadoPokemon);
                            Collections.sort(pokemonList, new Pokemon.SortById());
                            escuchadorDeLaVista.finish(pokemonList);
                        }
                    }, nombrePokemon);
                }
            }
        });
    }

}
