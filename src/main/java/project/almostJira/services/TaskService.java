package project.almostJira.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.almostJira.models.Project;
import project.almostJira.models.Task;
import project.almostJira.repositories.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> showAllTasks(){
        List<Task> taskList = taskRepository.findAll();
        return taskList;
    }


    public void saveTask(Task task){
        task.setCreated(LocalDateTime.now());
        taskRepository.save(task);
    }


}
