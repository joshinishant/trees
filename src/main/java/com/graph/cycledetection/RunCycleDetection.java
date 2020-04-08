package com.graph.cycledetection;

import java.util.logging.Logger;

public class RunCycleDetection {

    private static final Logger log= Logger.getLogger("RunCycleDetection");

    public static void main(String args[]){


        log.info("**************Directed Graph**************");
        Directed directedGraph= new Directed(4);
        directedGraph.addEdge(0, 1);
        directedGraph.addEdge(0, 2);
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(2, 0);
        directedGraph.addEdge(2, 3);
        directedGraph.addEdge(3, 3);


        if(directedGraph.detectCycle()){
            log.info("Graph contains cycle");
        }else {
            log.info("Graph doesn't contain cycle");
        }


        log.info("**************Undirected Graph**************");
        UnDirected unDirectedGraph = new UnDirected(5);
        unDirectedGraph.addEdge(1, 0);
        unDirectedGraph.addEdge(0, 2);
        unDirectedGraph.addEdge(2, 1);
        unDirectedGraph.addEdge(0, 3);
        unDirectedGraph.addEdge(3, 4);
        if (unDirectedGraph.detectCycle())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");

        unDirectedGraph = new UnDirected(3);
        unDirectedGraph.addEdge(0, 1);
        unDirectedGraph.addEdge(1, 2);
        if (unDirectedGraph.detectCycle())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}
