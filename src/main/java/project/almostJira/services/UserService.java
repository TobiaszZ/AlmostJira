package project.almostJira.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project.almostJira.models.User;
import project.almostJira.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(int id){
        User user = userRepository.findUserById(id);
        return user;

    }

    public void addAdmin(User user){


    }


    // show all users

    public List<User> showAllUser(){
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }
    // addUser z hash hasłem

    public void saveUser(User user){
        String hashedPass = hashPassword(user.getPassword());
        user.setPassword(hashedPass);
        userRepository.save(user);
    }
    // delete user
    public void deleteUser( int id){
        userRepository.deleteById(id);
    }

    //metoda hashujaca hasło
    private String hashPassword(String password){
        String hashedPassword = BCrypt.hashpw(password,BCrypt.gensalt());
        return hashedPassword;
    }

    public List<User> getAllUsers(){
        List<User> all = userRepository.findAll();
        return all;
    }

}
