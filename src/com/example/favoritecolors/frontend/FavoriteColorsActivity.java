package com.example.favoritecolors.frontend;

import java.util.ArrayList;
import java.util.List;

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
	private ArrayAdapter<String> adapter;
	private List<String> favoriteColors = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favorite_colors);

		service = ((FavoriteColorsApplication) getApplication()).getService();
		favoriteColors = service.findAllColors();

		ListView lv = (ListView) findViewById(R.id.favoriteColorsListView);
		adapter = new ArrayAdapter<String>(this, R.layout.favorite_colors_list_item,
				favoriteColors);
		lv.setAdapter(adapter);
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

	@Override
	protected void onResume() {
		if (adapter != null) {
			adapter.notifyDataSetChanged();
		}
		super.onResume();
	}

}
