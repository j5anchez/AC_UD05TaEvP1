package eus.birt.dam.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.repository.InstructorRepository;

@Controller
public class InstructorController {
	
	@Autowired
   	private InstructorRepository instructorRepository;
    
    @RequestMapping({"/instructors", "/"})
    public String getInstructors(Model model){

        model.addAttribute("instructors", instructorRepository.findAll());

        return "instructors/list";	
    }
 
}
