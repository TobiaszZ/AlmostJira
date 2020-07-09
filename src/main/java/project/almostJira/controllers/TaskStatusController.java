package project.almostJira.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.almostJira.models.TaskStatus;
import project.almostJira.services.TaskStatusService;

import java.util.List;

@Controller
@RequestMapping("/taskStatus")
public class TaskStatusController {

    @Autowired
    private TaskStatusService taskStatusService;

    @GetMapping("/showAll")
    public String showAllTaskStatus(Model model){
        List<TaskStatus> taskStatuses = taskStatusService.showAllTaskStatus();
        model.addAttribute("taskStatuses" ,taskStatuses);
        return "/taskStatuses/showAll";
    }

    @GetMapping("/add")
    public String addTaskStatus(Model model){
        model.addAttribute("taskStatus",new TaskStatus());
        return "/taskStatuses/addForm";
    }

    @PostMapping("/add")
    public String procesTaskStatus(@Validated TaskStatus taskStatus, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/taskStatuses/addForm";

        }else {
            taskStatusService.saveTaskStatus(taskStatus);
            return "redirect:/admin/options";
        }

    }



}
