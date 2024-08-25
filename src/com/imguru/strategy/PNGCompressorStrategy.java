package com.imguru.strategy;

public class PNGCompressorStrategy implements CompressorStrategy{

    @Override
    public void compress(String fileName) {
        System.out.println("Compressing it in PNG");
    }
}
