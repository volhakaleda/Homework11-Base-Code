package com.example.rusili.homework11.pokedexActivity.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.lang.reflect.Array;
import java.util.List;


public class PokemonAdapter extends RecyclerView.Adapter<PokemonViewHolder> {

    private PokemonEntries[] pokemonList;

    public PokemonAdapter() {
    }

    public void setData(PokemonEntries[] pokemonList){
        this.pokemonList = pokemonList;
        notifyDataSetChanged();
    }


    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_itemview, parent, false);
        return new PokemonViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        if(pokemonList != null) {
        PokemonEntries pokemonEntries = pokemonList[position];

        holder.onBind(pokemonEntries);
        }
    }

    @Override
    public int getItemCount() {
        if(pokemonList == null) {
            return 0;
        }
        return pokemonList.length;

    }
}
