package com.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;

public class BinaryTree {

    private static final Logger log= Logger.getLogger("BinaryTree");
    private Node root;

    public BinaryTree(Object key){
        this.root=new Node(key);
    }

    public void inorder(){
        if(root==null){
            return;
        }

        if(root.getLeft()!=null){
            inorder(root.getLeft());
        }

        if(root.getKey()!=null){
            log.info(root.getKey()+" ");
        }

        if(root.getRight()!=null){
            inorder(root.getRight());
        }
    }


    private void inorder(Node node){
        if(node==null){
            return;
        }

        if(node.getLeft()!=null){
            inorder(node.getLeft());
        }

        if(node.getKey()!=null){
            log.info(node.getKey()+" ");
        }

        if(node.getRight()!=null){
            inorder(node.getRight());
        }
    }

    public void insert(Object key){
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);


        while(!queue.isEmpty()){
            Node tempNode=queue.peek();
            queue.remove();

            if(tempNode.getLeft()==null){
                tempNode.setLeft(new Node(key));
                break;
            }else {
                queue.add(tempNode.getLeft());

                if(tempNode.getRight()==null){
                    tempNode.setRight(new Node(key));
                    break;
                }else {
                    queue.add(tempNode.getRight());
                }
            }
        }
    }


    public void delete(Node node){
        if(root==null)
            return ;

        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node keyNode=queue.peek();
            queue.remove();


            if(keyNode.getKey()==node.getKey()){

                Node deepestNode=popDeepestNode();

                if(deepestNode==null){
                    return;
                }

                keyNode.setKey(deepestNode.getKey());
                break;

            }else {

                if(keyNode.getRight()!=null){
                    queue.add(keyNode.getRight());
                }

                if(keyNode.getLeft()!=null){
                    queue.add(keyNode.getLeft());
                }
            }
        }
    }


    private Node popDeepestNode(){
        if(root==null)
            return null;

        Node deepestNode = null;

        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node currNode=queue.peek();
            queue.remove();

            if(currNode.getRight()!=null && currNode.getLeft()!=null){
                queue.add(currNode.getRight());
                queue.add(currNode.getLeft());
            }else if(currNode.getRight()==null && currNode.getLeft()!=null){
                queue.add(currNode.getLeft());
            }else if(currNode.getRight()!=null && currNode.getLeft()==null){
                queue.add(currNode.getRight());
            }else {
                deepestNode=new Node(currNode.getKey());
                currNode.setKey(null);
                return deepestNode;
            }
        }

        return deepestNode;

    }

}
