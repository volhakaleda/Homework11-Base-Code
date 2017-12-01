package com.example.rusili.homework11.pokedexActivity.view;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.view.PokemonDetailActivity;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;


public class PokemonViewHolder extends RecyclerView.ViewHolder {

    public static final String POKEMON_KEY = "pokemon";
    private TextView textView;
    private CardView card;



    public PokemonViewHolder(View itemView) {
        super(itemView);

        textView = (TextView) itemView.findViewById(R.id.pokemon_name_textview);
        card = (CardView) itemView.findViewById(R.id.card_view);
    }

    public void onBind(final PokemonEntries pokemonEntries) {
        textView.setText("Name: " + pokemonEntries.getPokemon_species().getName());
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(card.getContext(), PokemonDetailActivity.class);
                intent.putExtra(POKEMON_KEY, pokemonEntries.getPokemon_species().getName());
                card.getContext().startActivity(intent);
            }
        });
    }


}
