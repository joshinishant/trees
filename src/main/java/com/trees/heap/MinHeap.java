package com.trees.heap;

import java.util.logging.Logger;

public class MinHeap {

    private static final Logger log= Logger.getLogger("MinHeap");

    private int heap_array[];
    private int capcity;
    private int heapSize;

    public MinHeap(int capacity){
        this.capcity=capacity;
        this.heapSize=0;
        heap_array=new int[capacity];
    }

    public int getParent(int i){
        return (i-1)/2;
    }

    public int getRight(int i){
        return (2*i)+2;
    }

    public int getLeft(int i){
        return (2*i)+1;
    }

    public int getMin(){
        return heap_array[0];
    }

    public int extractMin(){

        if (heapSize <= 0)
            return Integer.MAX_VALUE;
        if (heapSize == 1)
        {
            heapSize--;
            return heap_array[0];
        }

        int minValue=heap_array[0];
        heap_array[0]=heap_array[heapSize-1];
        minHeapify(0);
        heapSize--;


        return minValue;
    }

    public int deleteMin(int index){
        int deletedValue=heap_array[index];
        minHeapify(index);
        return deletedValue;
    }

    private void minHeapify(int index){
        if(index==heapSize-1 ){
            return;
        }

        int smallestIndex=index;
        if( getLeft(index) < heapSize && heap_array[getLeft(index)] < heap_array[getRight(index)] ){
            smallestIndex=getLeft(index);
        }
        else if(getRight(index) < heapSize && heap_array[getRight(index)] < heap_array[getLeft(index)]){
            smallestIndex=getRight(index);
        }

        if(smallestIndex!=index){
            swap(index,smallestIndex);
            minHeapify(smallestIndex);
        }

    }

    public void insertKey(int key){

        if(capcity == heapSize){
            log.info("Heap is full");
        }
        int index=heapSize;
        heap_array[index]=key;
        heapSize++;

        while (index!=0 && heap_array[getParent(index)]>heap_array[index]){
            swap(index,getParent(index));
            index=getParent(index);
        }
    }

    public int deleteKey(int index){
        int deletedKey=heap_array[index];
        decreaseKey(index,Integer.MIN_VALUE);
        extractMin();
        return deletedKey;
    }


    public void decreaseKey(int index,int newKey){

        if(heap_array[index]<=newKey){
            log.info("Passed key '"+newKey+"' is greater than existing key '"+heap_array[index]+"' ");
        }

        heap_array[index]=newKey;
        while (index!=0 && heap_array[getParent(index)]>heap_array[index]){
            swap(index,getParent(index));
            index=getParent(index);
        }
    }

    private void swap(int i,int j){
        int temp;

        temp=heap_array[i];
        heap_array[i]=heap_array[j];
        heap_array[j]=temp;
    }

    public void printHeap(){
        for(int key:heap_array){
            log.info(" "+key+" ");
        }
    }

}
