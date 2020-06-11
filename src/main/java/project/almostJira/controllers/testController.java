package project.almostJira.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {
    @RequestMapping("/")
    @ResponseBody
    public String test(){
        return "działa";
    }
    @RequestMapping("/jsp")
    public String jsp(){
        return "test";

    }

}
