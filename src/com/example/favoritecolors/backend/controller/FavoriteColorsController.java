package com.example.favoritecolors.backend.controller;




import java.util.ArrayList;

public class FavoriteColorsController {

	private ArrayList<String> colorList;

	public FavoriteColorsController() {
		colorList = new ArrayList<String>();
	}

	public void addColor(String color) {
		colorList.add(color);
	}

	public ArrayList<String> findAll() {
		return colorList;
	}
	
}
