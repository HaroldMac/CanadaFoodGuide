package com.foodGuide.model;

import java.util.List;

import org.hibernate.validator.constraints.Range;

public class ServingRecommendation {
	
	@Range(min=1, max = 20)
	private int vegetablesAndFruits;
	@Range(min=1, max = 20)
	private int grains;
	@Range(min=1, max = 20)
	private int milkAndAlternatives;
	@Range(min=1, max = 20)
	private int meatAndAlternatives;
	
	public ServingRecommendation(){}
	
	public ServingRecommendation(List<FoodGroup> foodGroups){
		for (FoodGroup foodGroup : foodGroups){
			if (foodGroup.getIdentifier().equals("vf")){
				this.setVegetablesAndFruits(foodGroup.getRecommendedServings());
			}
			if (foodGroup.getIdentifier().equals("gr")){
				this.setGrains(foodGroup.getRecommendedServings());
			}
			if (foodGroup.getIdentifier().equals("mi")){
				this.setMilkAndAlternatives(foodGroup.getRecommendedServings());
			}
			if (foodGroup.getIdentifier().equals("me")){
				this.setMeatAndAlternatives(foodGroup.getRecommendedServings());
			}
		}	
	}
	
	
	
	
	public int getVegetablesAndFruits() {
		return vegetablesAndFruits;
	}
	
	public void setVegetablesAndFruits(int vegetablesAndFruits) {
		this.vegetablesAndFruits = vegetablesAndFruits;
	}
	
	public int getGrains() {
		return grains;
	}
	
	public void setGrains(int grains) {
		this.grains = grains;
	}
	
	public int getMilkAndAlternatives() {
		return milkAndAlternatives;
	}
	
	public void setMilkAndAlternatives(int milkAndAlternatives) {
		this.milkAndAlternatives = milkAndAlternatives;
	}
	
	public int getMeatAndAlternatives() {
		return meatAndAlternatives;
	}

	public void setMeatAndAlternatives(int meatAndAlteratives) {
		this.meatAndAlternatives = meatAndAlteratives;
	}

}
