package com.example.rusili.homework11.pokedexActivity.view;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;


public class PokedexFragment extends Fragment {
	private RetrofitFactory.PokedexNetworkListener pokedexNetworkListener;
	private PokemonAdapter pokemonAdapter;

	@Nullable
	@Override
	public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_layout, container, false);

		RecyclerView pokemonRecyclerView = (RecyclerView) view.findViewById(R.id.pokemon_recyclerview);


		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

		pokemonAdapter = new PokemonAdapter();

		pokemonRecyclerView.setAdapter(pokemonAdapter);
		pokemonRecyclerView.setLayoutManager(linearLayoutManager);

		getPokedexList();


		return view;
	}

	private void getPokedexList () {
		pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
			@Override
			public void pokedexCallback (Pokedex pokedex) {

				pokemonAdapter.setData(pokedex.getPokemon_entries());

			}
		};
		RetrofitFactory.getInstance().setPokedexListener(pokedexNetworkListener);
		RetrofitFactory.getInstance().getPokedex(2);
	}
}
