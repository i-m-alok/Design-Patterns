package com.imguru.builder;

import java.time.LocalDate;

public class ProductBuilder {


    private static Product product;

    public ProductBuilder(){
        this.reset();
        product = new Product();
    }
    public void id(Integer id){
        product.setId(id);
    }

    public void name(String name){
        product.setName(name);
    }

    public void manufacturedBy(String manufacturer){
        product.setManufacturedBy(manufacturer);
    }

    public void manufacturingDate(LocalDate date){
        product.setManufacturingDate(date);
    }

    public void expiryDate(LocalDate date){
        product.setExpiryDate(date);
    }

    public void productType(ProductType type){
        product.setProductType(type);
    }

    public void isInWarranty(Boolean isInWarranty){
        product.setIsInWarranty(isInWarranty);
    }

    public void price(Integer price){
        product.setPrice(price);
    }

    private void reset(){
        product = null;
    }

}
