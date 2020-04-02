package com.trees.heap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaxHeap {

    private static final Logger log= LoggerFactory.getLogger(MaxHeap.class);

    private int heap_array[];
    private int capcity;
    private int heapSize;

    public MaxHeap(int capacity){
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

    public int getMax(){
        return heap_array[0];
    }

    public int extractMax(){

        if (heapSize <= 0)
            return Integer.MIN_VALUE;
        if (heapSize == 1)
        {
            heapSize--;
            return heap_array[0];
        }

        int maxValue=heap_array[0];
        heap_array[0]=heap_array[heapSize-1];
        maxHeapify(0);
        heapSize--;
        

        return maxValue;
    }

    public int deleteMax(int index){
        int deletedValue=heap_array[index];
        maxHeapify(index);
        return deletedValue;
    }

    private void maxHeapify(int index){
        if(index==heapSize-1 ){
            return;
        }

        int largestIndex=index;
        if( getLeft(index) < heapSize && heap_array[getLeft(index)] > heap_array[getRight(index)] ){
            largestIndex=getLeft(index);
        }
        else if(getRight(index) < heapSize && heap_array[getRight(index)] > heap_array[getLeft(index)]){
            largestIndex=getRight(index);
        }

        if(largestIndex!=index){
            swap(index,largestIndex);
            maxHeapify(largestIndex);
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
        increaseKey(index,Integer.MAX_VALUE);
        extractMax();
        return deletedKey;
    }


    public void increaseKey(int index,int newKey){

        if(heap_array[index]>=newKey){
            log.info("Passed key '"+newKey+"' is smaller than existing key '"+heap_array[index]+"' ");
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
