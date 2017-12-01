package com.example.rusili.homework11.detailscreen.model;

import com.example.rusili.homework11.detailscreen.model.objects.Sprites;
import com.example.rusili.homework11.detailscreen.model.objects.Stats;
import com.example.rusili.homework11.detailscreen.model.objects.Types;

public class Pokemon {
	private Stats[] stats;
	private Sprites sprites;
	private Types[] types;

	public Stats[] getStats() {
		return stats;
	}

	public Sprites getSprites() {
		return sprites;
	}

	public Types[] getTypes() {
		return types;
	}
}
