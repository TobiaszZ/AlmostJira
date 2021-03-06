package project.almostJira.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.almostJira.models.Project;
import project.almostJira.models.Task;
import project.almostJira.models.User;
import project.almostJira.services.ProjectService;
import project.almostJira.services.TaskService;
import project.almostJira.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {


    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;


    @ModelAttribute("users")
    public List<User> users(){
        List<User> allUsers = userService.showAllUser();
        return allUsers;
    }



    @RequestMapping("/showAll")
    public String showAllProjects(Model model){
        List<Project> projects = projectService.showAllProjects();
        model.addAttribute("projects", projects);
        return "projects/showAll";

    }
    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable int id){
        projectService.deleteProject(id);
        return "redirect:/project/showAll";
    }

    @GetMapping("/add")
    public String addProject(Model model) {
        model.addAttribute("project", new Project());
        return "projects/addForm";
    }

    @PostMapping("/add")
    public String procesProject(@Validated Project project, BindingResult result) {
        if (result.hasErrors()) {
            return "projects/addForm";
        } else {
            projectService.saveProject(project);
            return "redirect:/admin/options";
        }
    }
    @GetMapping("/update/{id}")
    public String updateProject(@PathVariable int id,  Model model){
        Project project = projectService.findById(id);
        model.addAttribute("project", project);
        return "projects/addForm";
    }

    @PostMapping("/update/{id}")
    public String processUpdateProject(@Validated Project project, BindingResult result ){
        if (result.hasErrors()){
            return "projects/addForm";
        }else{

            projectService.updateProject(project);
            taskService.removeUsersFromProjectTasks(project);
            return "redirect:/project/showAll";
        }
    }


    @GetMapping("/details/{id}")
    public String showProjectDetails(@PathVariable int id, Model model){
        Project byId = projectService.findById(id);
        List<Project> oneElementLIst = new ArrayList<>();
        oneElementLIst.add(byId);
        model.addAttribute("project", oneElementLIst);
        return "projects/projectDetails";
    }


    @GetMapping("addUsers/{idForProject}")
    public String addUsersToTask( @PathVariable int idForProject, Model model){
        Project orginalProject = projectService.findById(idForProject);
        Project shadowProject = orginalProject;
        List<User> allUsers = userService.getAllUsers();

        model.addAttribute("project", shadowProject);
        model.addAttribute("users", allUsers);


        return "projects/addUsers";
    }

    @PostMapping("addUsers/{idForProject}")
    public String addUsersToTaskProcess(@Validated Project project){
        Project orginalProject = projectService.findById(project.getId());
        List<User> shadowProjectUserList = project.getUserList();
        projectService.addUsersToProject(orginalProject,shadowProjectUserList);

        projectService.updateProject(orginalProject);


        return "redirect:/project/showAll";
    }



}
