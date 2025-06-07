package BackTracking;

import java.util.ArrayList;

public class originalGFG_RatMaze {
    public static void main(String[] args) {
        int[][] maze = {{1,0,1,1,1,1},
                        {1,1,1,1,0,1},
                        {0,1,1,1,1,1},
                        {0,0,1,0,1,1}
                    };
        ArrayList<String> res = new ArrayList<>();
        boolean[][] isValid = new boolean[maze.length][maze[0].length];

        printPaths(0,0,maze.length-1,maze[0].length-1,res,"",maze,isValid);  // space complexity : O(N*M), not good.

        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
    }

    private static void printPaths(int sr, int sc, int er, int ec, ArrayList<String> res, String s, int[][] maze, boolean[][] isValid) {
        if(sr == er && sc == ec){
            res.add(s);
            return;
        }
        if(sr>er || sc>ec || sr<0 || sc<0 || maze[sr][sc] == 0 || isValid[sr][sc]) return;
        isValid[sr][sc] = true;

        // go up
        printPaths(sr-1, sc, er, ec, res, s+"U",maze, isValid);
        // go left
        printPaths(sr, sc-1, er, ec, res, s+"L",maze, isValid);
        // go right
        printPaths(sr, sc+1, er, ec, res, s+"R",maze, isValid);
        // go down
        printPaths(sr+1, sc, er, ec, res, s+"D",maze, isValid);

        isValid[sr][sc] = false;
    }
}
