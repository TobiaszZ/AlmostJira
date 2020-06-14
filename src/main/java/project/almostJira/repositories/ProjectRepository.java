package project.almostJira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.almostJira.models.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
