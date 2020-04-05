package com.trees.avltree;

import java.util.logging.Logger;

public class RunAVLTree {

    private static final Logger log=Logger.getLogger("RunAVLTree");

    public static void main(String args[]){
        AVLTree avlTree= new AVLTree(9);
        avlTree.insert(5);
        avlTree.insert(10);
        avlTree.insert(7);
        avlTree.insert(17);

        log.info("***************After create***************");
        avlTree.preOrderTraversal();

       // avlTree.delete(17);

        log.info("***************After delete***************");
        avlTree.preOrderTraversal();

    }
}
