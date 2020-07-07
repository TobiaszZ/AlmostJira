package project.almostJira.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.almostJira.models.TaskPriority;

import project.almostJira.services.TaskPriorityService;

import java.util.List;

@Controller
@RequestMapping("/taskPriority")
public class TaskPriorityController {

    private TaskPriorityService taskPriorityService;

    public String showAllTaskPriority(Model model) {
        List<TaskPriority> taskPriorities = taskPriorityService.showAllTaskPriority();
        model.addAttribute("taskPriorities", taskPriorities);
        return "/taskPriorities/showAll";
    }

    @GetMapping("/add")
    public String addTaskPriority(Model model) {
        model.addAttribute("taskPriority", new TaskPriority());
        return "/taskPriorities/addForm";
    }

    @PostMapping("/add")
    public String procesTaskPriority(@Validated TaskPriority taskPriority, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/add";
        } else {
            taskPriorityService.saveTaskPriority(taskPriority);
            return "redirect:/admin/options";
        }

    }
}