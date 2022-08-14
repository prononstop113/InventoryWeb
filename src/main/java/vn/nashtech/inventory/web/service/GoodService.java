package vn.nashtech.inventory.web.service;
import vn.nashtech.inventory.web.model.Good;
import vn.nashtech.inventory.web.model.GoodInput;



import java.util.List;

public interface GoodService {

    void editGood (Good formGood);
    void deleteGood(int id);


    String addGood (GoodInput formGood);

    List<Good> listGood();
}
