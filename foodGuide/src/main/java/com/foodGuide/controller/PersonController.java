package com.foodGuide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.foodGuide.model.Person;

@Controller
@SessionAttributes("person")
public class PersonController {
	
	@RequestMapping(value="/addPerson", method=RequestMethod.GET)
	public String addPerson(Model model){
		model.addAttribute("person", new Person());
		return "addPerson";
	}
	
	@RequestMapping(value="/addPerson", method=RequestMethod.POST)
	public String submitPerson(@RequestParam(value ="language", defaultValue = "en") String lang, @ModelAttribute ("person") Person person){
		
		if (lang.equals("fr")){
			person.setLanguage("fr");
		} else {
			person.setLanguage("en");
		}
		return "redirect:servingRecommendation.html";
	}
		
}
