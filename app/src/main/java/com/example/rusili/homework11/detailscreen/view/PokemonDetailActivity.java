package com.example.rusili.homework11.detailscreen.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.detailscreen.model.objects.Sprites;
import com.example.rusili.homework11.detailscreen.model.objects.Stats;
import com.example.rusili.homework11.detailscreen.model.objects.Type;
import com.example.rusili.homework11.detailscreen.model.objects.Types;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.view.PokemonViewHolder;
import com.squareup.picasso.Picasso;

public class PokemonDetailActivity extends AppCompatActivity{

	private RetrofitFactory.PokemonNetworkListener pokemonNetworkListener;
	private String pokemonName;

	@Override
	public void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pokemon_detail_activity);

		Intent intent = getIntent();
		pokemonName = intent.getStringExtra(PokemonViewHolder.POKEMON_KEY);

		initialize();

	}

	private void initialize () {
		getPokemonDetails();
	}

	private void getPokemonDetails () {
		pokemonNetworkListener = new RetrofitFactory.PokemonNetworkListener() {
			@Override
			public void pokemonCallback (Pokemon pokemon) {

				ImageView imageView = findViewById(R.id.pokemon_imageview);
				TextView textView = findViewById(R.id.pokemon_details_textview);
				TextView textView1 = findViewById(R.id.pokemon_details_textview1);
				TextView textView2 = findViewById(R.id.pokemon_details_textview2);
				TextView textView3 = findViewById(R.id.pokemon_details_textview3);
				TextView textView4 = findViewById(R.id.pokemon_details_textview4);
				TextView textView5 = findViewById(R.id.pokemon_details_textview5);
				TextView textView6 = findViewById(R.id.pokemon_details_textview6);
				TextView textView7 = findViewById(R.id.pokemon_details_textview7);
				TextView textView8 = findViewById(R.id.pokemon_details_textview8);
				TextView textView9 = findViewById(R.id.pokemon_details_textview9);
				TextView textView10 = findViewById(R.id.pokemon_details_textview10);
				TextView textView11 = findViewById(R.id.pokemon_details_textview11);
				TextView textView12 = findViewById(R.id.pokemon_details_textview12);

				Sprites sprites = pokemon.getSprites();

				Stats[] stats = pokemon.getStats();

				String value = String.valueOf(stats[0].getBase_stat());
				String value1 = String.valueOf(stats[1].getBase_stat());
				String value2 = String.valueOf(stats[2].getBase_stat());
				String value3 = String.valueOf(stats[3].getBase_stat());
				String value4 = String.valueOf(stats[4].getBase_stat());
				String value5 = String.valueOf(stats[5].getBase_stat());

				Types[] types = pokemon.getTypes();
				Types first = types[0];
				Type type = first.getType();
				String typeName = type.getName();

				Picasso.with(PokemonDetailActivity.this).load(sprites.getFront_default()).into(imageView);

				String stat0 = String.format("%s:", stats[0].getStat().getName());
				textView.setText(stat0);
				textView1.setText(value);

				String stat1 = String.format("%s:", stats[1].getStat().getName());
				textView2.setText(stat1);
				textView3.setText(value1);

				String stat2 = String.format("%s:", stats[2].getStat().getName());
				textView4.setText(stat2);
				textView5.setText(value2);

				String stat3 = String.format("%s:", stats[3].getStat().getName());
				textView6.setText(stat3);
				textView7.setText(value3);

				String stat4 = String.format("%s:", stats[4].getStat().getName());
				textView8.setText(stat4);
				textView9.setText(value4);

				String stat5 = String.format("%s:", stats[5].getStat().getName());
				textView10.setText(stat5);
				textView11.setText(value5);

				textView12.setText(typeName);


			}
		};

		RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
		RetrofitFactory.getInstance().getPokemon(pokemonName);
	}
}
