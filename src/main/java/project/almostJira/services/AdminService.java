package project.almostJira.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class AdminService {

    @RequestMapping("/adminPage")
    public String adminPage(){
        return "adminPage";
    }

}
