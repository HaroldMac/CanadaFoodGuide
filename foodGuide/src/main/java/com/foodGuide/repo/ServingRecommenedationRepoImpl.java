package com.foodGuide.repo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.foodGuide.model.FoodGroup;

@Repository("servingsRepo")
public class ServingRecommenedationRepoImpl implements ServingRecommendationRepo  {


	private FoodGroup vf = new FoodGroup("Vegetables and Fruit", "vf");
	private FoodGroup gr = new FoodGroup("Grains", "gr");
	private FoodGroup mi = new FoodGroup("Milk and Alternatives", "mi");
	private FoodGroup me = new FoodGroup("Meat and Alternatives", "me");

	private String fileName = "cfg_openData_2015-05-19_csv/en/servings_per_day-en_ONPP.csv";
	
	public ServingRecommenedationRepoImpl() {
	}
	
	public List<FoodGroup> findAllServings(String ageRange, String gender){
		
		List<FoodGroup> foodGroups = new ArrayList<FoodGroup>();
				
		this.getServingRecommendations(ageRange, gender);
		
	    foodGroups.add(vf);
	    foodGroups.add(gr);
	    foodGroups.add(mi);
	    foodGroups.add(me);
	    return foodGroups;
		
	}
	
	private void getServingRecommendations(String ageRange, String gender){
		String line = null;
	    try {
	    	ClassLoader loader = Thread.currentThread().getContextClassLoader();
	    	InputStream is = loader.getResourceAsStream(fileName);
	      	InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.ISO_8859_1);
	    	BufferedReader bufferedReader = new BufferedReader(streamReader);
	    	
	    	
	    	while((line = bufferedReader.readLine()) != null) {
	    		
	    		String [] recommendations = line.split(",");
	    		
	    		if ((recommendations[1].trim().equals(gender)) && (recommendations[2].trim()).equals(ageRange)) {
	    			if (recommendations[0].equals("vf")) {vf.setRecommendedServings(Integer.parseInt(recommendations[3].split(" ")[0])) ;}
	    			if (recommendations[0].equals("gr")) {gr.setRecommendedServings(Integer.parseInt(recommendations[3].split(" ")[0])) ;}
	    			if (recommendations[0].equals("mi")) {mi.setRecommendedServings(Integer.parseInt(recommendations[3].split(" ")[0])) ;}
	    			if (recommendations[0].equals("me")) {me.setRecommendedServings(Integer.parseInt(recommendations[3].split(" ")[0])) ;}
	    		}
	    		
	        }   
	    	bufferedReader.close();         
	    } catch(IOException ex) {
	    	System.out.println("Unable to open file '" + fileName + "'");                
	    }
	}

	
}
