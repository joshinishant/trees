package com.graph.minspanning;

public class RunMinSpanningTree {


    public static void main(String[] args){
        Graph graph= new Graph(4,5);
        graph.addEdge(0,1,10,0);
        graph.addEdge(0,2,6,1);
        graph.addEdge(0,3,5,2);
        graph.addEdge(1,3,15,3);
        graph.addEdge(2,3,4,4);

        MinSpanningTreeAlgorithms.krushkalsMethod(graph);


    }

}
