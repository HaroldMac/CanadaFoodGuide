package com.foodGuide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foodGuide.model.FoodGroup;
import com.foodGuide.model.Person;
import com.foodGuide.model.ServingRecommendation;
import com.foodGuide.service.FoodRecommendationService;
import com.foodGuide.service.ServingRecommendationService;

@Controller
public class RestController {
	
	@Autowired
	private ServingRecommendationService servingRecommendationService;
	@Autowired
	private FoodRecommendationService foodRecommendationService;

	@RequestMapping(value="/recommendation/{age}/{gender}/{language}", method = RequestMethod.GET)
	public @ResponseBody List<FoodGroup> showAllRecommendations(@PathVariable int age, @PathVariable String gender, @PathVariable String language){
		
		Person person = new Person(age, gender, language);
		List <FoodGroup> foodGroups = servingRecommendationService.findAllServings(person);
		for (FoodGroup foodGroup: foodGroups){
			foodGroup.setFoods(foodRecommendationService.findAllFoods(person, foodGroup));
		}
		return foodGroups;
	}
	
	@RequestMapping(value="/foods/{identifier}/{language}", method = RequestMethod.GET)
	public @ResponseBody List<String> showAllFoods(@PathVariable String identifier, @PathVariable String language){
		List<String> foods = foodRecommendationService.findAllFoods(identifier, language);
		return foods;
	}
	
	@RequestMapping(value="/servings/{age}/{gender}/{language}", method = RequestMethod.GET)
	public @ResponseBody ServingRecommendation showAllServings(@PathVariable int age, @PathVariable String gender, @PathVariable String language){
		Person person = new Person(age, gender, language);
		ServingRecommendation servingRecommendation = new ServingRecommendation(servingRecommendationService.findAllServings(person));
		return servingRecommendation;
	}


}
