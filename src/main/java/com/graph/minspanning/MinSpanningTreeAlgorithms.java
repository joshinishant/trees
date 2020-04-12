package com.graph.minspanning;

import java.util.Arrays;
import java.util.logging.Logger;

public class MinSpanningTreeAlgorithms {

    private static final Logger log = Logger.getLogger("MinSpanningTreeAlgorithms");

    public  static void krushkalsMethod(Graph graph){
        Graph.Edge minSpanTreeEdge[] = new Graph.Edge[graph.getTotalVertices()];
        Graph.Subtree subtreeSet[] = new Graph.Subtree[graph.getTotalVertices()];

        for(int counter=0;counter < graph.getTotalVertices(); counter++){
            minSpanTreeEdge[counter]= graph.new Edge();

            subtreeSet[counter]= graph.new Subtree();
            subtreeSet[counter].rank=0;
            subtreeSet[counter].parent=counter;
        }

        Arrays.sort(graph.getEdges());

        int edgeCount = 0;
        int resultCounter = 0;
        while (resultCounter < graph.getTotalVertices() - 1 && edgeCount < graph.getTotalEdges()){
            Graph.Edge nextEdge = graph.getEdges()[edgeCount];


            int subtreeRoot1 = graph.findRootOFSubTree(subtreeSet,nextEdge.getSource());
            int subtreeRoot2 = graph.findRootOFSubTree(subtreeSet,nextEdge.getDestination());

            if(subtreeRoot1 != subtreeRoot2){
                graph.combineTrees(subtreeSet,subtreeRoot1,subtreeRoot2);
                minSpanTreeEdge[resultCounter++] = nextEdge;
            }

            edgeCount++;

        }

        log.info("***********Minimum Spanning Tree By Krushkal's Method starts here***********");
        for(int counter=0;counter < resultCounter;counter++){
            log.info(minSpanTreeEdge[counter].toString());
        }
        log.info("***********Minimum Spanning Tree By Krushkal's Method ends here***********");


    }

}
