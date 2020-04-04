package com.trees.heap;

import java.util.logging.Logger;

public class RunHeap {

    private static final Logger log= Logger.getLogger("RunHeap");


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
