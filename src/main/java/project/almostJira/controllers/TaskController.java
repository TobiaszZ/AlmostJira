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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private ProjectService projectService;

    @GetMapping("/show/{id}")
    public String showAllTasks(Model model, @PathVariable int id) {
        Project project = projectService.findById(id);
        String projectId = project.getProjectId();
        String idForProject = project.getId().toString();
        List<Task> tasks = project.getTaskList();
        model.addAttribute("tasks", tasks);
        model.addAttribute("projectId", projectId);
        model.addAttribute("idForProject", idForProject);
        return "tasks/showAll";
    }

    @GetMapping("/showDetails/{id}/{idForProject}")
    public String showTaskDetails(Model model, @PathVariable int id, @PathVariable int idForProject) {
        Task task = taskService.findTaskById(id);
        List<Task> oneElementList = new ArrayList<>();
        oneElementList.add(task);
        model.addAttribute("task", oneElementList);
        model.addAttribute("idForProject", idForProject);
        return "tasks/taskDetails";

    }


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
    public String processTask(@Validated Task task, BindingResult result, @PathVariable int id) {
        if (result.hasErrors()) {
            return "tasks/addForm";
        } else {
            taskService.saveTask(task);
            Project project = projectService.findById(id);
            List<Task> taskList = project.getTaskList();
            taskList.add(task);
            projectService.updateProject(project);


            return "redirect:/project/showAll";
        }
    }

    @GetMapping("/update/{id}/{idForProject}")
    public String updateTask(@PathVariable int id,  Model model){
        Task task = taskService.findTaskById(id);
        model.addAttribute("task", task);
        return "tasks/addForm";
    }

    @PostMapping("/update/{id}/{idForProject}")
    public String processUpdateTask(@Validated Task task, BindingResult result ){
        if (result.hasErrors()){
            return "tasks/addForm";
        }else{
            taskService.updateTask(task);
            return "redirect:/task/show/{idForProject}";
        }
    }



    @GetMapping("delete/{id}/{idForProject}")
    public String deleteTask(@PathVariable int id , @PathVariable int idForProject){
        Project byId = projectService.findById(idForProject);
        List<Task> taskList = byId.getTaskList();
        Task taskById = taskService.findTaskById(id);
        taskList.remove(taskById);
        taskService.deleteTask(id);
        projectService.updateProject(byId);
        return "redirect:/task/show/"+idForProject;
    }

    @GetMapping("addUsers/{id}/{idForProject}")
    public String addUsersToTask(@PathVariable int id , @PathVariable int idForProject, Model model){
        Project byId = projectService.findById(idForProject);
        List<User> userList = byId.getUserList();
        Task taskById = taskService.findTaskById(id);
        Task shadowTask = taskById;

        model.addAttribute("task", shadowTask);
        model.addAttribute("usersList", userList);


        return "tasks/addUsers";
    }

    @PostMapping("addUsers/{id}/{idForProject}")
    public String addUsersToTaskProcess(@Validated Task task, @PathVariable int idForProject){
        Task orginalTask = taskService.findTaskById(task.getId());
        List<User> shadowTaskUserList = task.getUsers();
        taskService.addUsersToTask(orginalTask,shadowTaskUserList);

        taskService.updateTask(orginalTask);


        return "redirect:/task/show/"+idForProject;
    }


}
