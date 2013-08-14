package com.example.favoritecolors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class FavoriteColorsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favorite_colors);

		ListView lv = (ListView) findViewById(R.id.favoriteColorsListView);
		String[] favoriteColors = new String[] { "Blue", "Red", "Yellow", "Orange" };
		ListAdapter fcAdapter = new ArrayAdapter<String>(this, R.layout.favorite_colors_list_item,
				favoriteColors);
		lv.setAdapter(fcAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_favorite_colors_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_new:
			Intent intent = new Intent();
			intent.setClass(this, NewColorActivity.class);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
