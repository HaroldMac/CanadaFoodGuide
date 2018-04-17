package com.foodGuide.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.foodGuide.model.FoodGroup;
import com.foodGuide.model.Person;
import com.foodGuide.model.ServingRecommendation;
import com.foodGuide.service.FoodRecommendationService;
import com.foodGuide.service.ServingRecommendationService;

@Controller
@SessionAttributes("servingRecommendation")
public class ServingRecommendationController {
	
	@Autowired
	private ServingRecommendationService servingRecommendationService;
	@Autowired
	private FoodRecommendationService foodRecommendationService;

	
	@RequestMapping(value="servingRecommendation", method=RequestMethod.GET)
	public String showRecommendations(HttpServletRequest request, Model model){
		Person person = (Person)request.getSession().getAttribute("person");	
		
		List <FoodGroup> foodGroups = servingRecommendationService.findAllServings(person);
		
		ServingRecommendation servingRecommendation = new ServingRecommendation(foodGroups);
		model.addAttribute("servingRecommendation", servingRecommendation);	
		for (FoodGroup foodGroup: foodGroups){
			foodGroup.setFoods(foodRecommendationService.findAllFoods(person, foodGroup));
			model.addAttribute(foodGroup.getIdentifier(), foodGroup);
		}	
		return "recommendedServings";
	}
	

	@RequestMapping(value="servingRecommendation", method=RequestMethod.POST)
	public String postRecommendations(@ModelAttribute ("servingRecommendation") ServingRecommendation servingRecommendation ){
		return "foodOptions";
	}
	

	
	
}
