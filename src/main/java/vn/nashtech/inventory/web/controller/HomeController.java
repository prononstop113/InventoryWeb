package vn.nashtech.inventory.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.nashtech.inventory.web.model.Credentials;

@Controller
public class HomeController {
    @GetMapping(value= { "/", "/index" })
    public String index(Model model) {

        return "homePage";
    }
    @GetMapping ("/test")
    public String test (Model model){
        return  "test";
    }
    @GetMapping ("/signin")
    public String login (Model model){

      return  "signin";
    }


    @GetMapping ("/signup")
    public String register (Model model){
        return  "signup";
    }
    @GetMapping ("/403")
    public String forbiden (Model model){
        return  "403";
    }

}
