package project.almostJira.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project.almostJira.models.TaskStatus;
import project.almostJira.services.TaskStatusService;

import java.util.List;

@Controller
@RequestMapping("/taskStatus")
public class TaskStatusController {

    @Autowired
    private TaskStatusService taskStatusService;

    public String showAllTaskStatus(Model model){
        List<TaskStatus> taskStatuses = taskStatusService.showAllTaskStatus();
        model.addAttribute("taskStatuses" ,taskStatuses);
        return "/taskStatus/showAll";
    }

}
