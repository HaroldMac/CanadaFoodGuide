package com.foodGuide.repo;

import java.util.List;

import com.foodGuide.model.FoodGroup;

public interface FoodRecommendationRepo {

	List<String> findFoodRecommendations(String identifier, String lang);
	List<String> findFoodRecommendations(String identifier, int servings, String lang);
	List<String> findFoodRecommendations(FoodGroup foodGroup, String lang);

}