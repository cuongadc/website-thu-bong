package com.laptrinhjavaweb.dto;

public class ProductCategoryDTO extends AbstractDTO<ProductCategoryDTO> {

    private static final long serialVersionUID = -4553583583100510783L;

    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
