package com.graph.traversal;

import java.util.LinkedList;

public class Graph {

    private int totalVertices;
    private LinkedList<Integer> vertices[];

    public Graph(int vertices){
        this.totalVertices=vertices;
        this.vertices=new LinkedList[vertices];

        for(int count=0;count<vertices;count++){
            this.vertices[count]= new LinkedList<Integer>();
        }

    }

    public int getTotalVertices(){
        return totalVertices;
    }

    public LinkedList<Integer> getConnectedVertices(int startingVertex){

        if(this.vertices[startingVertex]==null && this.vertices[startingVertex].size() <= 0){
            return new LinkedList<Integer>();
        }

        return new LinkedList<Integer>(this.vertices[startingVertex]);
    }



    public void addEdge(int fromVertex,int toVertex){
        this.vertices[fromVertex].add(toVertex);
    }



}
