package com.patugarte.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.patugarte.R;
import com.patugarte.model.Pokemon;

import java.util.List;

public class RecyclerViewPokemonAdapter extends RecyclerView.Adapter<RecyclerViewPokemonAdapter.PokemonViewHolder> {

    private List<Pokemon> listaDePokemones;
    private Context context;

    public RecyclerViewPokemonAdapter(List<Pokemon> listaDePokemones, Context context) {
        this.listaDePokemones = listaDePokemones;
        this.context = context;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaInflada = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda_pokemon, parent, false);
        PokemonViewHolder pokemonViewHolder = new PokemonViewHolder(vistaInflada);
        return pokemonViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon unPokemon = listaDePokemones.get(position);
        holder.bindPokemon(unPokemon);
    }

    @Override
    public int getItemCount() {
        return listaDePokemones.size();
    }

    public void setListaDePokemones(List<Pokemon> listaDePokemones) {
        this.listaDePokemones = listaDePokemones;
        notifyDataSetChanged();
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewceldaPokemon;
        private TextView textViewceldaPokemon;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewceldaPokemon = itemView.findViewById(R.id.ImageView_ImagenPokemonCelda);
            textViewceldaPokemon = itemView.findViewById(R.id.TextView_NombrePokemonCelda);
        }

        public void bindPokemon(Pokemon pokemon) {
            Glide.with(itemView)
                    .load(pokemon.getImagen())
                    .into(imageViewceldaPokemon);
            textViewceldaPokemon.setText(pokemon.getNombre());
        }
    }
}
