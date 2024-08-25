package com.imguru.strategy.__to__discuss;

public interface CacheStrategy {

    public void evict();

    public Integer get();

    public void put(Integer ele, Integer val);

}
