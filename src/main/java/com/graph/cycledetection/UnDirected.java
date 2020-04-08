package com.graph.cycledetection;

import java.util.Iterator;
import java.util.LinkedList;

public class UnDirected {

    private int totalVertices=0;
    private LinkedList<Integer> adjacentVertices[];



    public UnDirected(int totalVertices){
        this.totalVertices=totalVertices;
        adjacentVertices=new LinkedList[totalVertices];

        for(int counter=0;counter<totalVertices;counter++){
            adjacentVertices[counter]= new LinkedList<Integer>();
        }
    }

    public void addEdge(int fromEdge,int toEdge){
        adjacentVertices[fromEdge].add(toEdge);
    }

    public boolean detectCycle(int vertex,boolean[] visitedArray,int parent){


        LinkedList<Integer> verticesList=adjacentVertices[vertex];
        Iterator<Integer> verticesListIterator=verticesList.iterator();

        visitedArray[vertex]=true;
        parent=vertex;

        while (verticesListIterator.hasNext()){
            int adjacentVertex=verticesListIterator.next();

            if(!visitedArray[adjacentVertex]){
               if(detectCycle(adjacentVertex,visitedArray,adjacentVertex)){
                   return true;
               }
            }else if(adjacentVertex!=parent){
                return true;
            }
        }
        return false;
    }

    public boolean detectCycle(){

        boolean[] visitedArray= new boolean[totalVertices];

        for(int counter=0;counter<totalVertices;counter++){
            if(!visitedArray[counter]){
                if(detectCycle(counter,visitedArray,-1)){
                    return true;
                }
            }
        }

        return false;
    }


}
