package vn.nashtech.inventory.web.service;
import vn.nashtech.inventory.web.model.FormInput;
import vn.nashtech.inventory.web.model.Good;



import java.util.List;

public interface GoodService {

    void editGood (Good formGood);


    String addGood (Good formGood);

    List<Good> listGood();
}
