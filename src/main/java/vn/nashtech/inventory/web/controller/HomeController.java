package vn.nashtech.inventory.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.nashtech.inventory.web.controller.Good.GoodController;
import vn.nashtech.inventory.web.controller.User.UserController;

@Controller
@Component
public class HomeController {
private final UserController userController;
private final GoodController goodController;
@Autowired
    public HomeController(UserController userController,GoodController goodController) {
        this.userController = userController;
    this.goodController = goodController;
    }

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
    public String listuser (Model model)  {
        model.addAttribute("listofuser",userController.listUser());
        return  "listuser";
    }
    @GetMapping ("/product")
    public String product (Model model)  {
        model.addAttribute("listofGood",goodController.listGood());
        return  "product";
    }
}
