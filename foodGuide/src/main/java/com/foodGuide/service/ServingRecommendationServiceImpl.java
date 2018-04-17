package com.foodGuide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodGuide.model.FoodGroup;
import com.foodGuide.model.Person;
import com.foodGuide.repo.ServingRecommendationRepo;

@Service("servingsService")
public class ServingRecommendationServiceImpl implements ServingRecommendationService  {
	
	@Autowired
	private ServingRecommendationRepo servingRecommendationRepo;

	public List<FoodGroup> findAllServings(Person person){
		
		String userGender   = this.checkGender(person.getGender());
		String userAgeRange = this.getAgeRange(person.getAge());
		
		List<FoodGroup> foodGroups = servingRecommendationRepo.findAllServings(userAgeRange, userGender);
		foodGroups = this.checkLanguage(foodGroups, person.getLanguage());
		
		return foodGroups;
	}
		
	private String checkGender(String gender) {
		if (gender.toLowerCase().equals("male")) {
			return "Male";
		} else if (gender.toLowerCase().equals("female")) {
			return "Female";
		} else if (gender.toLowerCase().equals("homme")) {
			return "Male";
		} else if (gender.toLowerCase().equals("femme")) {
			return "Female";
		} else {
			return "";
		}
	}
	
	private List<FoodGroup> checkLanguage(List<FoodGroup> foodGroups, String language) {
		
		if (language.equals("fr")){
			for (FoodGroup foodGroup : foodGroups){
				if (foodGroup.getIdentifier().equals("vf")){
					foodGroup.setDescription("Légumes et fruits");
				}
				if (foodGroup.getIdentifier().equals("gr")){
					foodGroup.setDescription("Produits céréaliers");
				}
				if (foodGroup.getIdentifier().equals("mi")){
					foodGroup.setDescription("Lait et substituts");
				}
				if (foodGroup.getIdentifier().equals("me")){
					foodGroup.setDescription("Viandes et substituts");
				}
			}	
		}
		
		return foodGroups;
	}
	
	private String getAgeRange(int age) {
		if ((age >= 2) && (age <= 3))        {return "2 to 3";  }
		else if ((age >= 4) && (age <= 8))   {return "4 to 8";  }
		else if ((age >= 9) && (age <= 13))  {return "9 to 13"; }
		else if ((age >= 14) && (age <= 18)) {return "14 to 18";}
		else if ((age >= 19) && (age <= 30)) {return "19 to 30";}
		else if ((age >= 31) && (age <= 50)) {return "31 to 50";}
		else if ((age >= 51) && (age <= 70)) {return "51 to 70";}
		else if (age >= 71)					 {return "71+"; 	}		
		return "";
	}
	
}
