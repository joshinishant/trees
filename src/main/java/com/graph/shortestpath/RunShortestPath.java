package com.graph.shortestpath;

public class RunShortestPath {


    public static void main(String args[]){
        int graph1[][] = new int[][] {
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
        };
        Dijkstra dijkstra= new Dijkstra(9,graph1);
        dijkstra.findMinDistance(0);


       int graph2[][] = new int[][]{
                {0,10,20,0},
                {10,0,5,16},
                {20,5,0,20},
                {0,16,20,0}
        };

       dijkstra= new Dijkstra(4,graph2);
       dijkstra.findMinDistance(0);


    }

}
