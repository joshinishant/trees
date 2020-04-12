package com.graph.minspanning;

public class Graph {


    private int totalVertices;
    private int totalEdges;
    private Edge[] edges;


    public int getTotalVertices() {
        return totalVertices;
    }

    public void setTotalVertices(int totalVertices) {
        this.totalVertices = totalVertices;
    }

    public int getTotalEdges() {
        return totalEdges;
    }

    public void setTotalEdges(int totalEdges) {
        this.totalEdges = totalEdges;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public void setEdges(Edge[] edges) {
        this.edges = edges;
    }

    public Graph(int vertices, int edges){
        totalEdges=edges;
        totalVertices=vertices;
        this.edges=new Edge[edges];
        for(int counter=0;counter<edges;counter++){
            this.edges[counter]=new Edge();
        }
    }

    public void addEdge(int sourceVertex,int destinationVertex,int weight,int counter){

        if(counter >= totalEdges || counter < 0 ){
            return;
        }

        edges[counter].source=sourceVertex;
        edges[counter].destination=destinationVertex;
        edges[counter].weight=weight;
    }

    class Edge implements Comparable<Edge>{
        private int source;
        private int destination;
        private int weight;

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

        public int getDestination() {
            return destination;
        }

        public void setDestination(int destination) {
            this.destination = destination;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return weight-o.weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "source=" + source +
                    ", destination=" + destination +
                    ", weight=" + weight +
                    '}';
        }
    }


    class Subtree{
        int parent;
        int rank;
    };


    public int findRootOFSubTree(Subtree[] subtrees, int vertex){

        if(subtrees[vertex].parent!=vertex){
            subtrees[vertex].parent=findRootOFSubTree(subtrees,subtrees[vertex].parent);
        }

        return subtrees[vertex].parent;
    }


    public void combineTrees(Subtree[] subtrees,int vertex1,int vertex2){

        int subtree1Root=findRootOFSubTree(subtrees,vertex1);
        int subtree2Root=findRootOFSubTree(subtrees,vertex2);

        if(subtrees[subtree1Root].rank > subtrees[subtree2Root].rank){
            subtrees[subtree2Root].parent=subtree1Root;
        }else if(subtrees[subtree2Root].rank > subtrees[subtree1Root].rank){
            subtrees[subtree2Root].parent=subtree1Root;
        }else {
            subtrees[subtree2Root].parent=subtree1Root;
            subtrees[subtree1Root].rank++;
        }
    }
}
