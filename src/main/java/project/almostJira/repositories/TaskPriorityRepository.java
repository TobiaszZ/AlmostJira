package project.almostJira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.almostJira.models.TaskPriority;

public interface TaskPriorityRepository extends JpaRepository<TaskPriority, Integer> {
}
