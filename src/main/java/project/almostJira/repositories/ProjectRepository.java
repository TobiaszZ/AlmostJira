package project.almostJira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.almostJira.models.Project;
import project.almostJira.models.Task;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

 Project findProjectByid(int id);

 @Query(value = "SELECT * FROM PROJECT_TASK_LIST WHERE PROJECT_ID = ?1", nativeQuery = true)
 List<Task> findAllTasksForProject(int id);

 @Query(value = "INSERT INTO PROJECT_TASK_LIST(project_id , task_list_id) VALUES( ?1 , ?2 ", nativeQuery = true)
 void insertTasks(int projectId, int taskId);

}
