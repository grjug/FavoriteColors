package com.example.favoritecolors.frontend;

import android.app.Application;

import com.example.favoritecolors.backend.service.FavoriteColorsService;

public class FavoriteColorsApplication extends Application {
	
	private static FavoriteColorsApplication application;
	private FavoriteColorsService service;
	
	public FavoriteColorsApplication getInstance() {
		return application;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		application = this;
		application.initialize();
	}

	private void initialize() {
		service = new FavoriteColorsService();
	}

	public FavoriteColorsService getService() {
		return service;
	}

}
