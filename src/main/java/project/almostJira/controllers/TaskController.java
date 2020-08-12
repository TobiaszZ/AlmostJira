package project.almostJira.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.almostJira.models.Project;
import project.almostJira.models.Task;
import project.almostJira.models.User;
import project.almostJira.services.ProjectService;
import project.almostJira.services.TaskService;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private ProjectService projectService;

    @GetMapping("/show/{id}")
    public String showAllTasks(Model model, @PathVariable int id){
        Project project = projectService.findById(id);
        List<Task> tasks = project.getTaskList();
        model.addAttribute("tasks",tasks);
        return "/tasks/showAll";
    }
// próby
    @GetMapping("/add/{id}")
    public String addTask(Model model, @PathVariable int id) {
        Project project = projectService.findById(id);
        List<User> userList = project.getUserList();
        Task task = new Task();
        task.setUsers(userList);
        model.addAttribute("task", task);
        return "tasks/addForm";
    }

    @PostMapping("/add/{id}")
    public String processTask(@Validated Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "tasks/addForm";
        } else {
            taskService.saveTask(task);
            return "redirect:/admin/options";
        }
    }

}
