package com.foodGuide.model;

import java.util.List;

public class FoodGroup {

	private String description, identifier;
	private int recommendedServings;
	private List<String> foods;

	public FoodGroup(){	
	}
	
	public FoodGroup(String desc, String identifier){
		this.description = desc;
		this.identifier = identifier;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getRecommendedServings() {
		return recommendedServings;
	}
	public void setRecommendedServings(int recommendedServings) {
		this.recommendedServings = recommendedServings;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public List<String> getFoods() {
		return foods;
	}

	public void setFoods(List<String> foods) {
		this.foods = foods;
	}
	
}
