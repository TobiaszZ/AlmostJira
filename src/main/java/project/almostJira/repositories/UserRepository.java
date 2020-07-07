package project.almostJira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.almostJira.models.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User , Integer> {

 User findUserById(int id);


}