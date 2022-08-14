package vn.nashtech.inventory.web.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class GoodInput implements Serializable {
    private static final long serialVersionUID = 1L;
    private String productCode;
    private String productName;
    private String productDescription;
    private Integer unitId;
    public GoodInput() {
    }
}
