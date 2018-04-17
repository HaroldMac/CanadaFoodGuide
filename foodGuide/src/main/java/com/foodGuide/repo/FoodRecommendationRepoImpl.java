package com.foodGuide.repo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.foodGuide.model.FoodGroup;

@Repository("foodRepo")
public class FoodRecommendationRepoImpl implements FoodRecommendationRepo {

	private int servings;
	private String language, fileName, foodGroupIdentifier;
	private ArrayList<String> possibleFoods;
	
	
	/* (non-Javadoc)
	 * @see com.foodGuide.repo.FoodRecommendationRepo#findFoodRecommendations(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	public List<String> findFoodRecommendations(String identifier, String lang){
		
		this.language = lang;
		possibleFoods = new ArrayList<String>();
		this.foodGroupIdentifier = identifier;
		
		this.selectFileName();
		this.readFoodFile();
		
		return possibleFoods;
	}
	
	public List<String> findFoodRecommendations(String identifier, int servings, String lang){
		
		this.servings = servings;
		this.language = lang;
		possibleFoods = new ArrayList<String>();
		this.foodGroupIdentifier = identifier;
		
		this.selectFileName();
		this.readFoodFile();
		this.selectRecommendedFoods();
		return possibleFoods;
	}
	
	public List<String> findFoodRecommendations(FoodGroup foodGroup, String lang){
		
		this.servings = foodGroup.getRecommendedServings();
		this.language = lang;
		this.foodGroupIdentifier = foodGroup.getIdentifier();
		possibleFoods = new ArrayList<String>();
		
		this.selectFileName();
		this.readFoodFile();
		this.selectRecommendedFoods();
		return possibleFoods;
	}
	
		
	private void selectFileName() {
		if (this.language.equals("fr")) {
			this.fileName = "cfg_openData_2015-05-19_csv/fr/foods-fr_ONPP_rev.csv";
		} else {
			this.fileName = "cfg_openData_2015-05-19_csv/en/foods-en_ONPP_rev.csv";
		}
	}
	
	private void readFoodFile() {	
	    String line = null;
	    try {
	    	ClassLoader loader = Thread.currentThread().getContextClassLoader();
	    	InputStream is = loader.getResourceAsStream(fileName);
	    	
	      	InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.ISO_8859_1);
	    	BufferedReader bufferedReader = new BufferedReader(streamReader);

	    	
	    	while((line = bufferedReader.readLine()) != null) {
	    		line = line.replace('"', ' ').trim();
	    		String [] foodDetails = line.split(",");
	    		if (foodDetails[0].equals(this.foodGroupIdentifier)) {
	    			possibleFoods.add(this.parseFoodDetails(foodDetails));
	    		}
	        }   
	    	bufferedReader.close();         
	    } catch(IOException ex) {
	    	System.out.println("Unable to open file '" + fileName + "'");                
	    }
	}
	
	private String parseFoodDetails(String[] food) {
		String foodList = "- ";
		String measurements = " (";
		for (int i = 2; i < food.length; i++) {
			boolean containsDigit = false;
			for(char c: food[i].toCharArray()) {
				if (Character.isDigit(c) || (Character.getType(c)== 11) ) {
					containsDigit = true;
					continue;
				}
			}
			if (!containsDigit) {
				foodList += food[i].trim() + " ";
			} else {
				measurements += food[i].trim() + ", ";
			}
		}
		measurements = measurements.substring(0, measurements.length()-2);
		String foodAndMeasurement = foodList + measurements + ")";
		return foodAndMeasurement;
	}
	
	
	private void selectRecommendedFoods() {
		Random rand = new Random();
		while(possibleFoods.size() > servings){
			possibleFoods.remove(rand.nextInt(possibleFoods.size()));
		}
		
	}
	
}
