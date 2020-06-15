package project.almostJira.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project.almostJira.models.Project;
import project.almostJira.services.ProjectService;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {


    @Autowired
    private ProjectService projectService;

    @RequestMapping("/showAll")
    public String showAllProjects(Model model){
        List<Project> projects = projectService.showAllProjects();
        model.addAttribute("projects", projects);
        return "projects/showAll";

    }


}
