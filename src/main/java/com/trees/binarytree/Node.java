package com.trees.binarytree;

import java.util.Objects;

public class Node {

    private Object key;
    private Node right;
    private Node left;

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Node(Object key){
        this.key=key;
        right=null;
        left=null;
    }


    @Override
    public boolean equals(Object o) {
       if(this.getKey() == null && o ==null){
           return true;
       }else {
           if(o == null){
               return false;
           }else if(this.getKey() != o){
               return false;
           }else {
               return true;
           }
       }
    }
}
