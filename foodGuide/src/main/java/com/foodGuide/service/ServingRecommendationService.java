package com.foodGuide.service;

import java.util.List;

import com.foodGuide.model.FoodGroup;
import com.foodGuide.model.Person;

public interface ServingRecommendationService {

	List<FoodGroup> findAllServings(Person person);

}