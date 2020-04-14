package com.graph.backtracking;

public class Knight {

    private int boardDimension;
    private int board[][];

    private static int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
    private static int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

    public Knight(int boardDimension){
        this.boardDimension=boardDimension;
        this.board=new int[boardDimension][boardDimension];

        for(int xCounter=0;xCounter < boardDimension;xCounter++){
            for(int yCounter=0; yCounter < boardDimension; yCounter++){
                board[xCounter][yCounter]=-1;
            }
        }

        board[0][0]=0;

    }


    private boolean isSafe(int x,int y){
        if(x >= 0 && x < boardDimension && y >= 0 && y < boardDimension && board[x][y]==-1){
            return true;
        }

        return false;
    }

    private boolean moveKnight(int x,int y,int stepCounter){

        if(stepCounter == (boardDimension*boardDimension)){
            return true;
        }

        for(int counter=0;counter< xMove.length;counter++){
            if(isSafe(x+xMove[counter],y+yMove[counter])){
                board[x+xMove[counter]][y+yMove[counter]]=stepCounter;
                if( moveKnight(x+xMove[counter],y+yMove[counter],stepCounter+1)){
                   return true;
               }
               else {
                   board[x+xMove[counter]][y+yMove[counter]]=-1;
               }
            }
        }
        return false;
    }


    public boolean solve(){
        if(moveKnight(0,0,1)){
            System.out.println("Knights tour can be solved for board with dimension of "+boardDimension+" X "+boardDimension);
            print();
            return true;
        }else{
            System.out.println("Knights tour can be solved for board with dimension of "+boardDimension+" X "+boardDimension);
            return false;
        }
    }

    private void print(){
        System.out.println("Knight's Trail");
        for(int xCounter=0;xCounter < boardDimension;xCounter++){
            for(int yCounter=0; yCounter < boardDimension; yCounter++){
                System.out.print(board[xCounter][yCounter]+"\t");
            }
            System.out.println();
        }
    }


}
