package project.almostJira.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.almostJira.models.TaskPriority;
import project.almostJira.repositories.TaskPriorityRepository;

import java.util.List;

@Service
public class TaskPriorityService {

    @Autowired
    private TaskPriorityRepository taskPriorityRepository;

    public List<TaskPriority> showAllTaskPriority(){
        List<TaskPriority> taskPriorityList = taskPriorityRepository.findAll();
        return taskPriorityList;
    }

    public void saveTaskPriority(TaskPriority taskPriority){
        taskPriorityRepository.save(taskPriority);

    }



}
