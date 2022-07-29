package vn.nashtech.inventory.web.controller.authen;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import vn.nashtech.inventory.web.model.FormInput;

@Controller
public class SignUpController {
    private RestTemplate rest = new RestTemplate();
    ResponseEntity<FormInput> response;

    @PostMapping("/signup") public String signup(FormInput form) {

        System.out.println(form.getUsername());
//        response = rest.postForEntity("http://localhost:8090/user/signup", u, FormInput.class);
        if (isOk(form).getStatusCode().is2xxSuccessful()) {
            return "redirect:/signin";
        } else
            return "redirect:/signup?error=true";
    }
    private ResponseEntity<?> isOk (FormInput form){
        try{
            response = rest.postForEntity("http://localhost:8090/user/signup", form, FormInput.class);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(response.getStatusCode().getReasonPhrase());
        }
    }
}
