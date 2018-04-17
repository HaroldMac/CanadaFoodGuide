package com.foodGuide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodGuide.model.FoodGroup;
import com.foodGuide.model.Person;
import com.foodGuide.repo.FoodRecommendationRepo;

@Service("foodService")
public class FoodRecommendationServiceImpl implements FoodRecommendationService {

	@Autowired
	private FoodRecommendationRepo foodRecommendation;
	
	/* (non-Javadoc)
	 * @see com.foodGuide.service.FoodRecommendationService#findAllFoods(com.foodGuide.model.Person, com.foodGuide.model.FoodGroup)
	 */
	public List<String> findAllFoods(Person person, FoodGroup foodGroup){
		
		List<String> foods = foodRecommendation.findFoodRecommendations(foodGroup.getIdentifier(), foodGroup.getRecommendedServings(), person.getLanguage());
		
		return foods;
	}
	
	public List<String> findAllFoods(Person person, String foodGroupCode){
		
		List<String> foods = foodRecommendation.findFoodRecommendations(foodGroupCode, person.getLanguage());
		
		return foods;
	}
	
public List<String> findAllFoods(String foodGroupCode, String language){
		
		List<String> foods = foodRecommendation.findFoodRecommendations(foodGroupCode, language);
		
		return foods;
	}
	
}
