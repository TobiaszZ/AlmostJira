package project.almostJira.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.almostJira.models.User;
import project.almostJira.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    // show all users

    public List<User> showAllUser(){
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

}
