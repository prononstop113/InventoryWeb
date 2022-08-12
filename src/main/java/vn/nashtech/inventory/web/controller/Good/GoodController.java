package vn.nashtech.inventory.web.controller.Good;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import vn.nashtech.inventory.web.model.Good;
import vn.nashtech.inventory.web.service.GoodService;

import java.util.List;
@Component
@Controller
public class GoodController {
    String message;
    private final GoodService goodService;

    public GoodController(GoodService goodService) {
        this.goodService = goodService;
    }
    @PostMapping("/good") public String signup(Good formGood, ModelMap model) {
        if (goodService.addGood(formGood).equalsIgnoreCase("Success")) {
            return "/good";
        } else
            message = goodService.addGood(formGood);
        model.addAttribute("messagelog", message);
        return "redirect:/good?error=true";
    }
    @PutMapping("/good") public String editUser(Good formGood) {
        goodService.editGood(formGood);
        return "/good";
    }
    public List<Good> listGood() {
        List<Good> list=goodService.listGood();
        return list;
    }
}
