package com.imguru.strategy;

public class JPEGCompressorStrategy implements CompressorStrategy {

    @Override
    public void compress(String fileName) {
        System.out.println("Compressing it in JPEG");
    }
}
