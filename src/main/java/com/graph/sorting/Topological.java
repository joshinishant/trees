package com.graph.sorting;

import com.graph.traversal.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.logging.Logger;

public class Topological {

    private static Logger log= Logger.getLogger("Topological");

    public static void sort(Graph graph){
        Stack<Integer> stack=new Stack<Integer>();
        boolean addedToStack[]= new boolean[graph.getTotalVertices()];
        for(int counter=0;counter<graph.getTotalVertices();counter++){
            sort(counter,graph,stack,addedToStack);
        }

        while (!stack.empty()){
            log.info(stack.pop()+" ");
        }

    }

    private static void sort(Integer vertex,Graph graph,Stack<Integer> stack,boolean[] addedToStack){

        LinkedList<Integer> connectedVertexList=graph.getConnectedVertices(vertex);
        Iterator<Integer> vertexIterator=connectedVertexList.iterator();
        while (vertexIterator.hasNext()){
            int value=vertexIterator.next();
            if(!addedToStack[value]){
                sort(value,graph,stack,addedToStack);
            }
        }

        if(!addedToStack[vertex]){
            stack.push(vertex);
            addedToStack[vertex]=true;

        }

    }


}
