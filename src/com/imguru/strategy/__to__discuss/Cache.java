package com.imguru.strategy.__to__discuss;

public class Cache {

    private Integer capacity;
    private CacheStrategy cacheStrategy;

    public Cache (Integer capacity, CacheStrategy cacheStrategy){
        this.capacity = capacity;
        this.cacheStrategy = cacheStrategy;
    }


    /*
    method is used to get the value of looked key if it is there in cache
     */
    public Integer get(Integer key){
        return (Integer) cacheStrategy.get();
    }

    /*
    method is used to put the new item in cache
     */
    public void put(Integer ele, Integer val){
        cacheStrategy.put(ele, val);
    }

    /*
    function help us to change our eviction strategy during runtime
     */
    public void setEvictionStrategy(CacheStrategy cacheStrategy) {
        this.cacheStrategy = cacheStrategy;
    }
}
