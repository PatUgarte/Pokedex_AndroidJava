package com.patugarte.controller;

import com.patugarte.dao.PokemonDao;
import com.patugarte.model.Pokemon;
import com.patugarte.util.ResultListener;

import java.util.List;

public class PokemonController {

    private PokemonDao pokemonDao = new PokemonDao();

    public void obtenerPokemones(final ResultListener<List<Pokemon>> escuchadorDeLaVista){
        pokemonDao.traerListaDePokemones(new ResultListener<List<Pokemon>>() {
            @Override
            public void finish(List<Pokemon> result) {
                escuchadorDeLaVista.finish(result);
            }
        });
    }

}
