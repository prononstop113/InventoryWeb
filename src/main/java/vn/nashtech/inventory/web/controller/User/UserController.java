package vn.nashtech.inventory.web.controller.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import vn.nashtech.inventory.web.model.FormInput;
import vn.nashtech.inventory.web.model.User;
import vn.nashtech.inventory.web.service.UserService;

import java.util.List;


@Controller
@Component
public class UserController {
    String message;
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/signup") public String signup(FormInput form, ModelMap model) {
        if (userService.signUp(form).equalsIgnoreCase("Success")) {
            return "redirect:/signin";
        } else
            message = userService.signUp(form);
        model.addAttribute("messagelog", message);
        return "redirect:/signup?error=true";
    }
    @PutMapping("/profile") public String editUser(FormInput edituser) {
        userService.editUser(edituser);
        return "/profile";
    }
    public List<User> listUser() {
        List<User> list=userService.listUser();
    return list;
    }
}
