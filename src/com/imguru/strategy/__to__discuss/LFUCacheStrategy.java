package com.imguru.strategy.__to__discuss;

import java.util.LinkedList;

public class LFUCacheStrategy<T> implements CacheStrategy {

    /*
    This method will evict using the LRU Strategy
     */
    @Override
    public void evict() {
        System.out.println("LFU Eviction Strategy");
    }

    @Override
    public Integer get(){
        return  0;
    }

    @Override
    public void put(Integer ele, Integer val){

    }
}


class Node{
    Integer data;
    Node prev;
    Node next;
    public Node(Integer ele){
        data = ele;
        prev = null;
        next = null;
    }
}

class CustomLinkedList extends LinkedList {

}