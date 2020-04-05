package com.trees.avltree;

import java.util.logging.Logger;

public class AVLTree {

    private AVLNode root;
    private static final Logger log=Logger.getLogger("AVLTree");


    public AVLTree(int key){
        root=new AVLNode(key);
    }

    public void insert(int key){
        if(key < root.getKey()){
            AVLNode leftNode=insert(root.getLeft(),key);
            root.setLeft(leftNode);
        }else {
            AVLNode rightNode=insert(root.getRight(),key);
            root.setRight(rightNode);
        }

        root.setHeight(Math.max(root.getLeft()==null?0:root.getLeft().getHeight(),root.getRight()==null?0:root.getRight().getHeight())+1);
    }

    private AVLNode insert(AVLNode node,int key){

        if(node == null){
            return new AVLNode(key);
        }

        if(key < node.getKey()){
            AVLNode leftNode=insert(node.getLeft(),key);
            node.setLeft(leftNode);
        }else {
            AVLNode rightNode=insert(node.getRight(),key);
            node.setRight(rightNode);
        }

        node.setHeight(Math.max(node.getLeft()==null?0:node.getLeft().getHeight(),node.getRight()==null?0:node.getRight().getHeight())+1);

        int balanceFactor = getBalanceFactor(node);


        if( balanceFactor > 1 && key < node.getLeft().getKey()){
            return rightRotate(node);
        }
        else if( balanceFactor > 1 && key > node.getLeft().getKey()){
            return leftRightRotate(node);
        }
        else if( balanceFactor > 1 && key > node.getRight().getKey()){
            return leftRotate(node);
        }
        else if( balanceFactor > 1 && key < node.getRight().getKey()){
            return rightLeftRotate(node);
        }


        return node;
    }

    public void delete(int key){

        if(root==null)
            return;

        if(key > root.getKey()){
            AVLNode leftNode=delete(root.getRight(),key);
            root.setLeft(leftNode);
        }else if(key < root.getKey()){
            AVLNode rightNode=delete(root.getLeft(),key);
            root.setRight(rightNode);
        }else {
            root=delete(root,key);
        }
    }

    private AVLNode delete(AVLNode node,int key){
        if(node==null)
            return node;


        if(key > node.getKey()){
            AVLNode leftNode=delete(node.getRight(),key);
            node.setLeft(leftNode);
        }else if(key < node.getKey()){
            AVLNode rightNode=delete(node.getLeft(),key);
            node.setRight(rightNode);
        }else {

            if(node.getRight()==null && node.getRight() == null){
                return null;
            }
            else if(node.getRight()==null || node.getRight() == null){
                AVLNode childNode=node.getRight()!=null?node.getRight():node.getLeft();
                if(childNode==null){
                    return null;
                }else {
                    node.setKey(childNode.getKey());
                    node.setRight(childNode.getRight());
                    node.setLeft(childNode.getLeft());
                }
            }else {
                AVLNode minValueNode=popMinimumvalueNode(node.getRight());
                node.setKey(minValueNode.getKey());
            }

            node.setHeight(Math.max(node.getLeft()==null?0:node.getLeft().getHeight(),node.getRight()==null?0:node.getRight().getHeight())+1);
            int balanceFactor = getBalanceFactor(node);


            if( balanceFactor > 1 && key < node.getLeft().getKey()){
                return rightRotate(node);
            }
            else if( balanceFactor > 1 && key > node.getLeft().getKey()){
                return leftRightRotate(node);
            }
            else if( balanceFactor > 1 && key > node.getRight().getKey()){
                return leftRotate(node);
            }
            else if( balanceFactor > 1 && key < node.getRight().getKey()){
                return rightLeftRotate(node);
            }

        }


        return node;
    }


    private AVLNode popMinimumvalueNode(AVLNode node){
        if(node==null){
            return node;
        }

        AVLNode prevNode=node;

        while(node.getLeft()!=null){
            prevNode=node;
            node=node.getLeft();
        }

        if(prevNode!=node){
            prevNode.setLeft(null);
        }

        return node;
    }

    public void preOrderTraversal(){
        if(root == null){
            return;
        }

        log.info(root.getKey()+" ");
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }


    public void preOrderTraversal(AVLNode node){
        if(node == null){
            return;
        }

        log.info(node.getKey()+" ");
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }

    private int getBalanceFactor(AVLNode node){

       int rightNodeHeight=node.getRight()==null?0:node.getRight().getHeight();
       int leftNodeHeight=node.getLeft()==null?0:node.getLeft().getHeight();

       return leftNodeHeight-rightNodeHeight;
    }


    private AVLNode leftRotate(AVLNode node){
        AVLNode rightChildNode=node.getRight();

        node.setRight(null);

        //performing rotation
        rightChildNode.setLeft(node);

        //updating heights of nodes
        node.setHeight(Math.max(node.getLeft()==null?0:node.getLeft().getHeight(),node.getRight()==null?0:node.getRight().getHeight())+1);
        rightChildNode.setHeight(Math.max(rightChildNode.getLeft()==null?0:rightChildNode.getLeft().getHeight(),rightChildNode.getRight()==null?0:rightChildNode.getRight().getHeight())+1);

        return rightChildNode;
    }

    private AVLNode rightRotate(AVLNode node){
        AVLNode leftChildNode=node.getLeft();

        node.setLeft(null);

        //performing rotation
        leftChildNode.setRight(node);

        //updating heights of nodes
        node.setHeight(Math.max(node.getLeft()==null?0:node.getLeft().getHeight(),node.getRight()==null?0:node.getRight().getHeight())+1);
        leftChildNode.setHeight(Math.max(leftChildNode.getLeft()==null?0:leftChildNode.getLeft().getHeight(),leftChildNode.getRight()==null?0:leftChildNode.getRight().getHeight())+1);

        return leftChildNode;
    }


    private AVLNode leftRightRotate(AVLNode node){
        AVLNode leftChildNode=node.getLeft();
        AVLNode rightGrandchildNode=leftChildNode.getRight();

        node.setLeft(null);

        //performing rotation
        leftChildNode.setLeft(rightGrandchildNode);
        leftChildNode.setRight(node);

        //updating heights of nodes
        node.setHeight(Math.max(node.getLeft()==null?0:node.getLeft().getHeight(),node.getRight()==null?0:node.getRight().getHeight())+1);
        leftChildNode.setHeight(Math.max(leftChildNode.getLeft()==null?0:leftChildNode.getLeft().getHeight(),leftChildNode.getRight()==null?0:leftChildNode.getRight().getHeight())+1);

        return leftChildNode;
    }


    private AVLNode rightLeftRotate(AVLNode node){
        AVLNode rightChildNode=node.getRight();
        AVLNode leftGrandChildNode=rightChildNode.getLeft();

        node.setRight(null);

        //performing rotation
        rightChildNode.setRight(leftGrandChildNode);
        rightChildNode.setLeft(node);

        //updating heights of nodes
        node.setHeight(Math.max(node.getRight()==null?0:node.getRight().getHeight(),node.getLeft()==null?0:node.getLeft().getHeight())+1);
        rightChildNode.setHeight(Math.max(rightChildNode.getLeft()==null?0:rightChildNode.getLeft().getHeight(),rightChildNode.getRight()==null?0:rightChildNode.getRight().getHeight())+1);

        return rightChildNode;
    }

}
