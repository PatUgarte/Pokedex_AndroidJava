package com.patugarte.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.patugarte.R;
import com.patugarte.controller.PokemonController;
import com.patugarte.model.Pokemon;
import com.patugarte.util.ResultListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    private List<Pokemon> listaDePokemonesMVC;
    private RecyclerViewPokemonAdapter adapterPokemon;
    private RecyclerView recyclerViewDePokemones;
    private PokemonController pokemonController;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        recyclerViewDePokemones = view.findViewById(R.id.RecyclerViewPokemones);
        listaDePokemonesMVC = new ArrayList<>();
        adapterPokemon = new RecyclerViewPokemonAdapter(listaDePokemonesMVC,this.getContext());
        pokemonController = new PokemonController();

        pokemonController.obtenerPokemones(new ResultListener<List<Pokemon>>() {
            @Override
            public void finish(List<Pokemon> result) {
                adapterPokemon.setListaDePokemones(result);
            }
        });

        recyclerViewDePokemones.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false));
        recyclerViewDePokemones.setAdapter(adapterPokemon);
        recyclerViewDePokemones.setHasFixedSize(true);

        return view;
    }

}
