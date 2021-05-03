package miu.edu.lab6.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/class")
    public String classes(){
        return "class";
    }

    @GetMapping("/faculty")
    @Secured("ROLE_FACULTY")
    public String faculty(){
        return "faculty";
    }

    @GetMapping("/student")
    @Secured("ROLE_STUDENT")
    public String student(){
        return "student";
    }

}
