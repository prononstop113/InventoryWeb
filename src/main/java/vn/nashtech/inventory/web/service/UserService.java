package vn.nashtech.inventory.web.service;

import org.springframework.stereotype.Component;
import vn.nashtech.inventory.web.model.FormInput;
import vn.nashtech.inventory.web.model.User;


import java.util.List;

public interface UserService {

    void editUser (FormInput form);

    String signUp (FormInput form);

    List<User> listUser();
}
