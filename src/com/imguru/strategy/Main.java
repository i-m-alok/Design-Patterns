package com.imguru.strategy;



public class Main {
    public static void main(String[] args) {
        ImageStorage imageStorage = new ImageStorage();

        imageStorage.store("myFile", new BlackNWhiteFilterStrategy(), new PNGCompressorStrategy());

        imageStorage.store("mySecondFile", new BlackNWhiteFilterStrategy(), new JPEGCompressorStrategy());

    }


}
