package com.trees.avltree;

public class AVLNode {

    private int key;
    private AVLNode left;
    private AVLNode right;
    private int height;


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public AVLNode(int key){
        this.key=key;
        this.left=null;
        this.right=null;
        this.height=1;
    }

}
