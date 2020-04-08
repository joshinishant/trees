package com.graph.cycledetection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Directed {

    private int totalVertices=0;
    private List<Integer> adjacentVerticesArray[];


    public Directed(int totalVertices){
        this.totalVertices=totalVertices;
        adjacentVerticesArray=new LinkedList[totalVertices];

        for(int counter=0;counter<totalVertices;counter++){
            adjacentVerticesArray[counter]=new LinkedList<Integer>();
        }
    }

    public void addEdge(int fromVertex,int toVertex){
        adjacentVerticesArray[fromVertex].add(toVertex);
    }

    public boolean detectCycle(){

        boolean[] visitedArray= new boolean[totalVertices];
        boolean[] recursionStatus = new boolean[totalVertices];


        for(int counter=0;counter<totalVertices;counter++){
            if(detectCycle(counter,visitedArray,recursionStatus)){
                return true;
            }
        }

        return false;
    }

    public boolean detectCycle(int vertex,boolean[] visitedArray,boolean[] recursionStatus){


        List<Integer> vertexList=adjacentVerticesArray[vertex];
        Iterator<Integer> vertexListIterator=vertexList.iterator();

        while (vertexListIterator.hasNext()){
            Integer adjacentVertex= vertexListIterator.next();

            if(recursionStatus[adjacentVertex]){
                return true;
            }

            visitedArray[adjacentVertex]=true;
            recursionStatus[adjacentVertex]=true;

            if(!visitedArray[adjacentVertex]){
                if( detectCycle(adjacentVertex,visitedArray,recursionStatus)){
                    return true;
                }
            }
        }

        recursionStatus[vertex]=false;

        return false;
    }

}
