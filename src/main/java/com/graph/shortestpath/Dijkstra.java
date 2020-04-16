package com.graph.shortestpath;

public class Dijkstra {

    private int totalVertices;
    private int verticeDistanceMatrix[][];


    public Dijkstra(int totalVertices,int verticeDistanceMatrix[][]){
        this.totalVertices=totalVertices;
        this.verticeDistanceMatrix=verticeDistanceMatrix;
    }


    private int minDistance(int[] distance,boolean[] status){
        int minValue=Integer.MAX_VALUE;
        int minIndex=-1;

        for(int counter=0;counter<totalVertices;counter++){
            if(status[counter]==false && distance[counter]<=minValue){
                minValue=distance[counter];
                minIndex=counter;
            }
        }

        return minIndex;

    }

    private void print(int distance[]){
        System.out.println("Vertex \t\t Distance from Source");
        for (int counter = 0; counter < totalVertices; counter++) {
            System.out.println(counter + " \t\t\t " + distance[counter]);
        }
        System.out.println("\n\n");
    }


    public void findMinDistance(int sourceVertex){


        int distance[]= new int[totalVertices];
        boolean status[]=new boolean[totalVertices];

        for(int counter=0;counter<totalVertices;counter++){
            distance[counter]=Integer.MAX_VALUE;
            status[counter]=false;
        }

        distance[sourceVertex]=0;

        for(int counter=0;counter<totalVertices-1;counter++){

            int minVertex=minDistance(distance,status);
            status[minVertex]=true;

            for (int index=0;index<totalVertices;index++){
                if(!status[index] && verticeDistanceMatrix[minVertex][index]!=0 && distance[minVertex]!=Integer.MAX_VALUE ){
                    distance[index]=distance[index]>distance[minVertex]+verticeDistanceMatrix[minVertex][index]
                    ?distance[minVertex]+verticeDistanceMatrix[minVertex][index]:distance[index];

                }
            }
        }

        print(distance);
    }
}
