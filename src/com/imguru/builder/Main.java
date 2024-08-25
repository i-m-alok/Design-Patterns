package com.imguru.builder;

public class Main {

    public static void main(String[] args){

        ProductBuilder product = new ProductBuilder();
        product.productType(ProductType.ELECTRONICS);
        product.price(500);
    }
}
