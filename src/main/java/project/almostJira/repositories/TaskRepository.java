package project.almostJira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.almostJira.models.Project;
import project.almostJira.models.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    Task findTaskByid(int id);
}
