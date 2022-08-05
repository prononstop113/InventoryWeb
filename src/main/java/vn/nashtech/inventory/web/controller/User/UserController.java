package vn.nashtech.inventory.web.controller.User;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import vn.nashtech.inventory.web.model.FormInput;
import vn.nashtech.inventory.web.model.User;


@Controller
public class UserController {
    RestTemplate rest = new RestTemplate();
    ResponseEntity<?> response;
    String message;
    @ModelAttribute
    @PostMapping("/signup") public String signup(FormInput form, ModelMap model) {

        if (isOK(form).equalsIgnoreCase("Success")) {
            return "redirect:/signin";
        } else
            message= isOK(form);

            model.addAttribute("messagelog",message);
            return "redirect:/signup?error=true";
    }
        public String isOK(FormInput form)
        {
            String msg ;
            try{
                response = rest.postForEntity("http://localhost:8090/user/signup", form, String.class);
                msg= response.getBody().toString();
                return msg;
            } catch (HttpClientErrorException e) {
                msg =e.getResponseBodyAsString();
                return  msg;
            }
        }
    @PutMapping("/profile")
    public String editUser (FormInput edituser,ModelMap model){
            rest.put("http://localhost:8090/updateProfile/{id}",edituser, User.class);
    return "/profile";
}
}
