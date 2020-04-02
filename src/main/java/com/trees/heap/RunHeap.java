package com.trees.heap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunHeap {

    private static final Logger log= LoggerFactory.getLogger(RunHeap.class);


    public static void main(String[] args){
        MinHeap minHeap=new MinHeap(11);
        minHeap.insertKey(3);
        minHeap.insertKey(2);
        minHeap.deleteKey(1);
        minHeap.insertKey(15);
        minHeap.insertKey(5);
        minHeap.insertKey(4);
        minHeap.insertKey(45);
        System.out.println(" "+minHeap.extractMin());
        System.out.println(" "+minHeap.getMin());
        minHeap.decreaseKey(2, 1);
        System.out.println  (" "+minHeap.getMin());
    }
}
