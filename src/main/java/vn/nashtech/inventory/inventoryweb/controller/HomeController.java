package vn.nashtech.inventory.inventoryweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
}
