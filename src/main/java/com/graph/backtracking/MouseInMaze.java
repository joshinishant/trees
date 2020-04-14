package com.graph.backtracking;

public class MouseInMaze {

    private int board[][];
    private int mazeLength=0;
    private int mazeWidth=0;

    public MouseInMaze(){
        this.board=new int[1][1];
    }

    public boolean solve(int board[][]){
        this.board=board;
        boolean widthFlag=false;

        for(int row[]:board){
            for(int column: row){
                if(!widthFlag){
                    mazeWidth++;
                }
            }
            widthFlag=true;
            mazeLength++;
        }

        System.out.println("Height of Maze "+ mazeLength);
        System.out.println("Width of Maze "+ mazeWidth);
        if(move(0,0)){
            System.out.println("Maze solved!!");
            board[0][0]=100;
            print();
            return true;
        }else {
            System.out.println("Maze cannot be solved");
            return false;
        }
    }


    private void print(){
        for(int xCounter=0;xCounter<mazeWidth;xCounter++){
            for(int yCounter=0;yCounter<mazeWidth;yCounter++){
                System.out.print(board[xCounter][yCounter]==100?"X":" ");
            }
            System.out.println();
        }
    }


    private boolean move(int x,int y){

        if(x==mazeLength-1 && y==mazeWidth-1){
            return true;
        }

        board[x][y]=1;
        if(isSafe(x+1,y)){
            if(move(x+1,y)){
                board[x+1][y]=100;
                return true;
            }
            else {
                board[x+1][y]=-1;
            }
        }

        if(isSafe(x,y+1)){
            if(move(x,y+1)){
                board[x][y+1]=100;
                return true;
            }
            else {
                board[x][y+1]=-1;
            }
        }

        return false;
    }

    private boolean isSafe(int x,int y){
        if(x >= 0 && x < mazeLength && y >= 0 && y < mazeWidth && board[x][y]==1){
            return true;
        }

        return false;
    }

}
