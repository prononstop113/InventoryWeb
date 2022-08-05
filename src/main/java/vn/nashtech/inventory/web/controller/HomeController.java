package vn.nashtech.inventory.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import vn.nashtech.inventory.web.model.Credentials;
import vn.nashtech.inventory.web.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    RestTemplate rest = new RestTemplate();
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
    @GetMapping ("/profile")
    public String profile (Model model){
        return  "profile";
    }
    @GetMapping ("/listuser")
    public String listuser (Model model){
        List<User> list = new ArrayList<>();
        rest.getForEntity("http://localhost:8090/user/listUser", User.class);
        System.out.println(rest);
//model.addAttribute();

        return  "listuser";
    }

}
