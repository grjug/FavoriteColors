package com.example.favoritecolors.backend.service;

import java.util.ArrayList;

import com.example.favoritecolors.backend.controller.FavoriteColorsController;

public class FavoriteColorsService {

	private FavoriteColorsController colorController;

	public FavoriteColorsService() {
		this.colorController = new FavoriteColorsController();
	}

	public void addColor(String color) {
		this.colorController.addColor(color);
	}

	public ArrayList<String> findAllColors() {
		return this.colorController.findAll();
	}
}
