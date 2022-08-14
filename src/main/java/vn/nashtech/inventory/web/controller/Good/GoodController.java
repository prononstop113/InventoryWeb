package vn.nashtech.inventory.web.controller.Good;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.nashtech.inventory.web.model.Good;
import vn.nashtech.inventory.web.model.GoodInput;
import vn.nashtech.inventory.web.service.GoodService;

import java.util.List;
@Component
@Controller
@RequestMapping("/good")
public class GoodController {
    String message;
    private final GoodService goodService;

    public GoodController(GoodService goodService) {
        this.goodService = goodService;
    }
    @PostMapping("") public String addGood(GoodInput formGood, ModelMap model) {

        if (goodService.addGood(formGood).equalsIgnoreCase("Success")) {
            return "redirect:/product";
        } else
            message = goodService.addGood(formGood);
        model.addAttribute("messagelog", message);
        return "redirect:/product?error=true";
    }
    @PutMapping("/{id}") public String updateGood(Good formGood) {
        goodService.editGood(formGood);
        return "redirect:/product";
    }
    @DeleteMapping("/{id}") public String deleteGood(int id) {
        goodService.deleteGood(id);
        return "redirect:/product";
    }
    public List<Good> listGood() {
        List<Good> list=goodService.listGood();
        return list;
    }
}
