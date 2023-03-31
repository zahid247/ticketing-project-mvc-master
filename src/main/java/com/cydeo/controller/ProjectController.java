package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/project")
public class ProjectController {

    ProjectService projectService;
    UserService userService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createProject(Model model){

        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects", projectService.findAll());

        List<UserDTO> managers = userService.findAll().stream()
                .filter(userDTO -> userDTO.getRole().getDescription().equals("Manager"))
                .collect(Collectors.toList());
//the list above works fine, just for some reason it is skipping the first user in the list

        model.addAttribute("managers", managers);

//        model.addAttribute("managers", userService.findAll());

        return "project/create";
    }

}
