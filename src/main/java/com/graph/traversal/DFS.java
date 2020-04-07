package com.graph.traversal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Logger;

public class DFS{

    private static Logger log=Logger.getLogger("DFS");


    private static void depthFirstSearch(Graph graph,int startingVertex,boolean[] visitedArray){

        visitedArray[startingVertex]=true;
        log.info(startingVertex+" ");

        LinkedList<Integer> connectedVertices=graph.getConnectedVertices(startingVertex);

        Iterator<Integer> vertexIterator=connectedVertices.iterator();
        while (vertexIterator.hasNext()){
            int vertex=vertexIterator.next();

            if(!visitedArray[vertex]){
                depthFirstSearch(graph,vertex,visitedArray);
            }
        }
    }


    public static void depthFirstSearch(Graph graph,int startingVertex){
        int totalVertices=graph.getTotalVertices();
        boolean[] visitedArray=new boolean[totalVertices];
        depthFirstSearch(graph,startingVertex,visitedArray);
    }
}
