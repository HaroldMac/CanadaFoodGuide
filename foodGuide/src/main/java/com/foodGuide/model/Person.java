package com.foodGuide.model;

import org.hibernate.validator.constraints.Range;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class Person {

	@Range(min=1, max = 100)
	private int age;
	private String gender;
	private String language;
	
	public Person(){}
	
	public Person(int age, String gender, String language){
		this.age = age;
		this.gender = gender;
		this.language = language;
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
}
