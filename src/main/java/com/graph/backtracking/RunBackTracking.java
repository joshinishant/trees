package com.graph.backtracking;

public class RunBackTracking {

    public static void main(String args[]){
        Knight knight= new Knight(8);
        knight.solve();

        int maze[][] =
        {   { 1, 0, 0, 0 },
            { 1, 1, 0, 1 },
            { 0, 1, 0, 0 },
            { 1, 1, 1, 1 }
        };

        MouseInMaze mouseInMaze= new MouseInMaze();
        mouseInMaze.solve(maze);

    }

}
