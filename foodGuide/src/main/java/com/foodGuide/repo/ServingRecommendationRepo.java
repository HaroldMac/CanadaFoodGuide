package com.foodGuide.repo;

import java.util.List;

import com.foodGuide.model.FoodGroup;

public interface ServingRecommendationRepo {

	List<FoodGroup> findAllServings(String ageRange, String gender);

}