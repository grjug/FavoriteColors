package com.example.favoritecolors.frontend;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.favoritecolors.R;
import com.example.favoritecolors.backend.service.FavoriteColorsService;

public class NewColorActivity extends Activity {

	EditText txtColorName;

	private FavoriteColorsService service = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_color);

		service = ((FavoriteColorsApplication) getApplication()).getService();

		txtColorName = (EditText) this.findViewById(R.id.txtFirstName);
		txtColorName.requestFocus();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_new_color, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_submit:
			addNewColor();
			NewColorActivity.this.finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void addNewColor() {
		String colorName = txtColorName.getText().toString();
		service.addColor(colorName);
	}

}
