package com.graph.traversal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Logger;

public class BFS {

    private static Logger log=Logger.getLogger("BFS");

    public static void breadthFirstSearch(Graph graph,int startingVertex){
        int totalVertices=graph.getTotalVertices();
        boolean[] visitedArray=new boolean[totalVertices];

        LinkedList<Integer> queue=new LinkedList<Integer>();
        queue.add(startingVertex);

        while (!queue.isEmpty()){
            int vertex=queue.poll();
            visitedArray[vertex]=true;
            log.info(vertex+" ");

            LinkedList<Integer> connectedVertices=graph.getConnectedVertices(vertex);
            Iterator<Integer> verticesIterator=connectedVertices.iterator();
            while (verticesIterator.hasNext()){
                int connectedVertex=verticesIterator.next();
                if(!visitedArray[connectedVertex]){

                    queue.add(connectedVertex);
                }
            }
        }
    }
}
