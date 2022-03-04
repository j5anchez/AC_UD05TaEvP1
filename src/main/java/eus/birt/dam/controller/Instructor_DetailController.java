package eus.birt.dam.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.repository.Instructor_DetailRepository;

@Controller
public class Instructor_DetailController {
	
	@Autowired
   	private Instructor_DetailRepository instructor_detailRepository;
    
    @RequestMapping({"/instructor_details", "/"})
    public String getInstructor_DetailProject(Model model){

        model.addAttribute("instructor_details", instructor_detailRepository.findAll());

        return "instructor_details/list";	
    }
 
}
 