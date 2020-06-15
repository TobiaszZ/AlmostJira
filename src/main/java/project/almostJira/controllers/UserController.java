package project.almostJira.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project.almostJira.models.User;
import project.almostJira.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/showAll")
    public String showAllUsers (Model model){
        List<User> users = userService.showAllUser();
        model.addAttribute("users", users);
        return "users/showAll";
    }


}
