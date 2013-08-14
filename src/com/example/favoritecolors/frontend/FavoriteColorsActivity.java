package com.example.favoritecolors.frontend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.favoritecolors.R;
import com.example.favoritecolors.backend.service.FavoriteColorsService;

public class FavoriteColorsActivity extends Activity {
	
	private FavoriteColorsService service = null;
	ListView lv;
	ArrayAdapter<Object> fcAdapter;
	Object[] favoriteColors;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favorite_colors);
		
		service = ((FavoriteColorsApplication) getApplication()).getService();

		lv = (ListView) findViewById(R.id.favoriteColorsListView);
		setAdapter();
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
	
	private void setAdapter() {
		fcAdapter = new ArrayAdapter<Object>(this, R.layout.favorite_colors_list_item,
				service.findAllColors());
		lv.setAdapter(fcAdapter);
	}
	
	@Override
	protected void onResume() {
		setAdapter();
		super.onResume();
	}

}
