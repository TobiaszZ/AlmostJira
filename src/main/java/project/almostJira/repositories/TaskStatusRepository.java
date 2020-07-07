package project.almostJira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.almostJira.models.TaskStatus;

public interface TaskStatusRepository extends JpaRepository<TaskStatus , Integer> {

    TaskStatus findTaskStatusById(int id);

}
