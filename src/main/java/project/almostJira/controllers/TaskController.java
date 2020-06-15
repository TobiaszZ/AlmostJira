package project.almostJira.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project.almostJira.models.Task;
import project.almostJira.services.TaskService;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    public String showAllTasks(Model model){
        List<Task> tasks = taskService.showAllTasks();
        model.addAttribute("tasks",tasks);
        return "/tasks/showAll";
    }
}
