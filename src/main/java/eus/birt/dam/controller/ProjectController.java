package eus.birt.dam.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.repository.ProjectRepository;

@Controller
public class ProjectController {
	
	@Autowired
   	private ProjectRepository projectRepository;
    
    @RequestMapping({"/projects", "/"})
    public String getProjects(Model model){

        model.addAttribute("projects", projectRepository.findAll());

        return "projects/list";	
    }
 
}
