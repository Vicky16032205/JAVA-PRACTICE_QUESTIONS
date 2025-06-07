package BackTracking;

import java.util.ArrayList;

public class RatMazeOptimized {
    public static void main(String[] args) {
        int[][] maze = {{1,0,1,1,1,1},
                        {1,1,1,1,0,1},
                        {0,1,1,1,1,1},
                        {0,0,1,0,1,1}
                    };
        ArrayList<String> res = new ArrayList<>();

        printPaths(0,0,maze.length-1,maze[0].length-1,res,"",maze);  // space complexity : O(1), good.

        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
    }

    private static void printPaths(int sr, int sc, int er, int ec, ArrayList<String> res, String s, int[][] maze) {
        if(sr == er && sc == ec){
            res.add(s);
            return;
        }
        if(sr>er || sc>ec || sr<0 || sc<0 || maze[sr][sc] == 0 || maze[sr][sc] == -1) return;
        maze[sr][sc] = -1;

        // go up
        printPaths(sr-1, sc, er, ec, res, s+"U",maze);
        // go left
        printPaths(sr, sc-1, er, ec, res, s+"L",maze);
        // go right
        printPaths(sr, sc+1, er, ec, res, s+"R",maze);
        // go down
        printPaths(sr+1, sc, er, ec, res, s+"D",maze);

        maze[sr][sc] = 1;
    }
}
