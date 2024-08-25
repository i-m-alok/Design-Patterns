package com.imguru.strategy;

public class BlackNWhiteFilterStrategy implements FilterStrategy{

    @Override
    public void apply(String fileName){
        System.out.println("Apply Black and White Strategy");
    }
}
