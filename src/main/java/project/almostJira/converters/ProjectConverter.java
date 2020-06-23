package project.almostJira.converters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import project.almostJira.models.Project;
import project.almostJira.services.ProjectService;


public class ProjectConverter implements Converter<String, Project> {

    @Autowired
    ProjectService projectService;

    @Override
    public Project convert(String s) {
        return projectService.findById(Integer.parseInt(s));
    }
}
