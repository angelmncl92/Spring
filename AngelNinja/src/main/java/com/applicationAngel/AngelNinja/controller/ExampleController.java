package com.applicationAngel.AngelNinja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.applicationAngel.AngelNinja.model.Person;

@Controller
@RequestMapping("/example")
public class ExampleController {

	private static final String EXAMPLE_VIEW = "example";
	
	//Primera forma
	
//	@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		
		model.addAttribute("name", "Angel");
		model.addAttribute("person", new Person("Angel", 26));
		model.addAttribute("people", getPeople());
		return EXAMPLE_VIEW;
	}
	
	//Segunda forma
	
//	@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {	
		
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("name", "Cristina");
		mav.addObject("person", new Person("Cristina", 25));
		mav.addObject("people", getPeople());
		
		return mav;
	}
	
	private List<Person> getPeople(){
		List<Person> people = new ArrayList<>();
		people.add(new Person("Daniel", 26));
		people.add(new Person("Alberto", 20));
		people.add(new Person("Sergio", 32));
		people.add(new Person("Raquel", 32));
		people.add(new Person("Fernando", 35));
		return people;
	}
}
