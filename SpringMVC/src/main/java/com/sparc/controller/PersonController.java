package com.sparc.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sparc.dao.PersonDAO;
import com.sparc.entity.Person;


@Controller
@RequestMapping("/")
public class PersonController {

	
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	   public ModelAndView person() {
		ApplicationContext context = new ClassPathXmlApplicationContext("person-beans.xml");
	
		Person person = (Person) context.getBean("person");
	      return new ModelAndView("person", "command", person);
	   }
	
	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	  public String showLogin( @ModelAttribute("person")Person person, BindingResult result, ModelMap model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("person-beans.xml");

		PersonDAO personDAO = (PersonDAO) context.getBean("personDAO");
		personDAO.addPerson(person);
		model.addAttribute("firstName", person.getFirstName());
		model.addAttribute("lastName", person.getLastName());
		
		return "success";
	  }

	
	

}
