package com.foodGuide.service;

import java.util.List;

import com.foodGuide.model.FoodGroup;
import com.foodGuide.model.Person;

public interface FoodRecommendationService {

	List<String> findAllFoods(Person person, FoodGroup foodGroup);
	List<String> findAllFoods(Person person, String foodGroupCode);
	List<String> findAllFoods(String foodGroupCode, String language);

}