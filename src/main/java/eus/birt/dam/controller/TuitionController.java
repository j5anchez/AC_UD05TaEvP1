package eus.birt.dam.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.repository.TuitionRepository;

@Controller
public class TuitionController {
	
	@Autowired
   	private TuitionRepository tuitionRepository;
    
    @RequestMapping({"/tuitions", "/"})
    public String getTuitions(Model model){

        model.addAttribute("tuitions", tuitionRepository.findAll());

        return "tuitions/list";	
    }
 
}
