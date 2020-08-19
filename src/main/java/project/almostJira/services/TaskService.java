package project.almostJira.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.almostJira.models.Project;
import project.almostJira.models.Task;
import project.almostJira.models.User;
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

    public void updateTask(Task task){
        taskRepository.save(task);
    }




    public Task findTaskById(int id){
        Task task = taskRepository.findTaskByid(id);
        return task;
    }

    public void deleteTask(int id){
        taskRepository.deleteById(id);
    }

    public void removeUsersFromProjectTasks(Project project) {
        List<Task> taskList = project.getTaskList();
        List<User> projectUserList = project.getUserList();

        for (int i = 0; i < projectUserList.size(); i++) {

            for (Task task : taskList) {

                List<User> taskUsers = task.getUsers();


                for (int j = 0; j < taskUsers.size(); j++) {
                    if (!(projectUserList.contains(taskUsers.get(j)))) {
                        taskUsers.remove(taskUsers.get(j));
                    }

                }

                updateTask(task);
            }

        }

    }


    public void addUsersToTask(Task task, List<User> list){
        List<User> taskUsers = task.getUsers();
        for (int i = 0 ; i < list.size(); i++){
            if(!(taskUsers.contains(list.get(i)))){
                taskUsers.add(list.get(i));
            }
        }


    }

}
