package com.graph.backtracking;

public class NQueenProblem {


    private int boardDimensions;
    private int totalQueenCount;
    private int[][] board;


    public NQueenProblem(int boardDimensions){
        this.boardDimensions=boardDimensions;
        board=new int[boardDimensions][boardDimensions];

        for(int rowCounter=0;rowCounter<boardDimensions;rowCounter++){
            for(int colCounter=0;colCounter<boardDimensions;colCounter++){
                board[rowCounter][colCounter]=0;
            }
        }
    }


    public boolean fitQueensInBoard(int totalQueenCount){

        this.totalQueenCount=totalQueenCount;

        if(findSpot(0)){
            System.out.println("It's possible to accommodate all queens\n\n");
            print();
            return true;
        }

        System.out.println("It's not possible to accommodate all queens");
        return false;
    }

    private void print(){
        for(int rowCounter=0;rowCounter<boardDimensions;rowCounter++) {
            for (int colCounter = 0; colCounter < boardDimensions; colCounter++) {
                System.out.print(board[rowCounter][colCounter]==0?"EMPTY\t":"QUEEN\t");
            }
            System.out.println();
        }
    }

    private boolean findSpot(int column){

        if(column>=totalQueenCount){
            return true;
        }

        for(int counter=0;counter<boardDimensions;counter++){
            if(isSafe(counter,column)){
                board[counter][column]=1;
                if(findSpot(column+1)){
                    return true;
                }
                board[counter][column]=0;
            }
        }
        return false;
    }

    private boolean isSafe(int x,int y){
        if(!(x >= 0 && x < boardDimensions && y >= 0 && y < boardDimensions)){
            return false;
        }

        for(int counterX=x;counterX>=0;counterX--){
            if(board[counterX][y]==1){
                return false;
            }
        }

        for(int counterY=y;counterY>=0;counterY--){
            if(board[x][counterY]==1){
                return false;
            }
        }

        for(int counterX=x,counterY=y;counterX>=0 && counterY>=0;counterX--,counterY--){
            if(board[counterX][counterY]==1){
                return false;
            }
        }
        for(int counterX=x,counterY=y;counterX>=0 && counterY<boardDimensions;counterX--,counterY++){
            if(board[counterX][counterY]==1){
                return false;
            }
        }

        return true;
    }




}
