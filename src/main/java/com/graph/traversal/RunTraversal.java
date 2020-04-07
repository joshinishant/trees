package com.graph.traversal;

import java.util.logging.Logger;

public class RunTraversal {

    private static Logger log=Logger.getLogger("RunTraversal");

    public static void main(String args[]){
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        log.info("*********DFS*************");
        DFS.depthFirstSearch(graph,2);
        log.info("*********DFS*************");

        log.info("*********BFS*************");
        BFS.breadthFirstSearch(graph,2);
        log.info("*********BFS*************");

    }



}
