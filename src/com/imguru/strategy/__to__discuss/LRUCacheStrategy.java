package com.imguru.strategy.__to__discuss;

public class LRUCacheStrategy implements CacheStrategy {

    /*
    This method will evict using the LRU Strategy
     */
    @Override
    public void evict() {
        System.out.println("LRU Eviction Strategy");
    }

    @Override
    public Integer get(){
        return  0;
    }


    @Override
    public void put(Integer ele, Integer val){
    }
}
