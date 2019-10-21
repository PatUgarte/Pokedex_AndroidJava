package com.patugarte.dao;

import com.patugarte.model.Pokemon;
import com.patugarte.util.ResultListener;

import java.util.ArrayList;
import java.util.List;

public class PokemonDao {

    public void traerListaDePokemones(ResultListener<List<Pokemon>> escuchadorDelController){
        escuchadorDelController.finish(generarListaDePokemones());
    }

    private List<Pokemon> generarListaDePokemones(){
        List<Pokemon> listaDePokemones = new ArrayList<>();

        listaDePokemones.add(new Pokemon("Bulbasaur","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png","unknown"));
        listaDePokemones.add(new Pokemon("Ivysaur","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png","unknown"));
        listaDePokemones.add(new Pokemon("Venusaur","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png","unknown"));
        listaDePokemones.add(new Pokemon("Charmander","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png","unknown"));
        listaDePokemones.add(new Pokemon("Charmeleon","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png","unknown"));
        listaDePokemones.add(new Pokemon("Charizard","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png","unknown"));
        listaDePokemones.add(new Pokemon("Squirtle","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png","unknown"));
        listaDePokemones.add(new Pokemon("Wartortle","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/8.png","unknown"));
        listaDePokemones.add(new Pokemon("Blastoise","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png","unknown"));

        return listaDePokemones;
    }
}

