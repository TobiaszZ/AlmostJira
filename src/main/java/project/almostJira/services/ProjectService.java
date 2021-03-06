package project.almostJira.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.almostJira.models.Project;
import project.almostJira.models.Task;
import project.almostJira.models.User;
import project.almostJira.repositories.ProjectRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> showAllProjects() {
        List<Project> projectList = projectRepository.findAll();
        return projectList;
    }

    //    public Project  findById(int id){
//        List<Project> all = projectRepository.findAll();
//        Project project = all.get(0);
//        return project;
//    }


//    public Project updateProject(){
//        projectRepository.sa
//        return null;
//    }

    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }

    public Project findById(int id) {
        Project project = projectRepository.findProjectByid(id);
        return project;
    }

    public void saveProject(Project project) {
        project.setCreated(LocalDateTime.now());
        project.setProjectId(createProjectId(project.getName()));
        projectRepository.save(project);
    }

    public void updateProject(Project project) {
        project.setProjectId(createProjectId(project.getName()));
        Integer id = project.getId();

        projectRepository.save(project);

    }

    private String createProjectId(String name) {
        String projectId = deletePolishLetters(name);
        projectId = name.replaceAll(" ", "-");
        return projectId;
    }

    private String deletePolishLetters(String name) {
        List<Character> characterList = Arrays.asList('ą', 'ć', 'ę', 'ł', 'ń', 'ó', 'ś', 'ż', 'ź');
        List<Character> characters = name.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        for (int i = 0; i < characters.size(); i++) {
            for (Character a : characterList) {
                if (a == characters.get(i)) {
                    characters.remove(i);
                    break;
                }
            }

        }
        return characters.toString();
    }

    public List<Task> findTasksForProject(int id) {
        List<Task> allTasksForProject = projectRepository.findAllTasksForProject(id);
        return allTasksForProject;
    }

    public void addUsersToProject(Project project, List<User> list) {
        List<User> projectUsers = project.getUserList();
        for (int i = 0; i < list.size(); i++) {
            if (!(projectUsers.contains(list.get(i)))) {
                projectUsers.add(list.get(i));
            }
        }


    }


//        for(int i = 0 ; i < userList.size(); i++){
//            List<User> newUsers = new ArrayList<>();
//            for (Task task: taskList) {
//
//                List<User> taskUsers = task.getUsers();
//
//                User projectUser = userList.get(i);
//                for (User taskUser:taskUsers) {
//                    if(projectUser==taskUser){
//                        newUsers.add(taskUser);
//                    }
//
//                }
//
//            }
//
//        }


//    public void insertTask(int projectId, int taskId){
//        projectRepository.insertTasks(projectId, taskId);
//    }
}
