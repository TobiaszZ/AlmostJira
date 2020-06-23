package project.almostJira.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.almostJira.models.User;
import project.almostJira.services.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/showAll")
    public String showAllUsers(Model model) {
        List<User> users = userService.showAllUser();
        model.addAttribute("users", users);
        return "users/showAll";
    }


    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "users/addForm";
    }

    @PostMapping("/add")
    public String procesUser(@Validated User user, BindingResult result) {
        if (result.hasErrors()) {
            return "users/addForm";
        } else {
           userService.saveUser(user);
            return "redirect:/admin/options";
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return "redirect:/user/showAll";
    }

}
