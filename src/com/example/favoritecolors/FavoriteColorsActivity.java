package com.example.favoritecolors;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class FavoriteColorsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favorite_colors);
		
		ListView lv = (ListView) findViewById(R.id.favoriteColorsListView);
		String[] favoriteColors = new String[]{"Blue", "Red", "Yellow", "Orange"};
		ListAdapter fcAdapter = new ArrayAdapter<String>(this, R.layout.favorite_colors_list_item, favoriteColors);
		lv.setAdapter(fcAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.favorite_colors, menu);
		return true;
	}

}
