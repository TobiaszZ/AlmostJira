package project.almostJira.services;

import org.springframework.stereotype.Service;
import project.almostJira.models.TaskStatus;
import project.almostJira.repositories.TaskStatusRepository;

import java.util.List;

@Service
public class TaskStatusService {


    private TaskStatusRepository taskStatusRepository;


    public List<TaskStatus> showAllTaskStatus() {
        List<TaskStatus> taskStatusList = taskStatusRepository.findAll();
        return taskStatusList;
    }

    public void saveTaskStatus(TaskStatus taskStatus) {
        taskStatusRepository.save(taskStatus);
    }

}
