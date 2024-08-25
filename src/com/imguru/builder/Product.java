package com.imguru.builder;

import java.time.LocalDate;

public class Product {

    private Integer id;
    private String name;
    private String manufacturedBy;
    private LocalDate manufacturingDate;
    private LocalDate expiryDate;
    private Enum<ProductType> productType;
    private Boolean isInWarranty;
    private Integer price;


    public void setId(Integer id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setManufacturedBy(String manufacturer){
        this.manufacturedBy = manufacturer;
    }

    public void setManufacturingDate(LocalDate date){
        this.manufacturingDate = date;
    }

    public void setExpiryDate(LocalDate date){
        this.expiryDate = date;
    }

    public void setProductType(ProductType type){
        this.productType = type;
    }

    public void setIsInWarranty(Boolean isInWarranty){
        this.isInWarranty = isInWarranty;
    }

    public void setPrice(Integer price){
        this.price = price;
    }
}
