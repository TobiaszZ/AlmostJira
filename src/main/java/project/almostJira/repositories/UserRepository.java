package project.almostJira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.almostJira.models.User;

public interface UserRepository extends JpaRepository<User , Integer> {
}