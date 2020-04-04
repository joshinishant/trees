package com.trees.binarytree;

public class RunBinaryTree {


    public static void main(String[] args){
        BinaryTree binaryTree=new BinaryTree(10);
        binaryTree.insert(11);
        binaryTree.insert(9);
        binaryTree.insert(7);
        binaryTree.insert(12);
        binaryTree.insert(15);
        binaryTree.insert(8);

       // binaryTree.inorder();



        binaryTree.delete(new Node(11));
        binaryTree.inorder();
    }
}
