package project.almostJira.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project.almostJira.models.TaskPriority;
import project.almostJira.services.TaskPriorityService;

import java.util.List;

@Controller
@RequestMapping("/taskPriority")
public class TaskPriorityController {

    private TaskPriorityService taskPriorityService;

    public String showAllTaskPriority(Model model){
        List<TaskPriority> taskPriorities = taskPriorityService.showAllTaskPriority();
        model.addAttribute("taskPriorities", taskPriorities);
        return "/taskPriorities/showAll";
    }

}
