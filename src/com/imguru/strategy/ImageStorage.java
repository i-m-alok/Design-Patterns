package com.imguru.strategy;

public class ImageStorage {

    public void store(String fileName, FilterStrategy filter, CompressorStrategy compressor){
        compressor.compress(fileName);
        filter.apply(fileName);
    }
}
