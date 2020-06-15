package project.almostJira.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.almostJira.models.Project;
import project.almostJira.repositories.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> showAllProjects(){
        List<Project> projectList = projectRepository.findAll();
        return  projectList;
    }

}
