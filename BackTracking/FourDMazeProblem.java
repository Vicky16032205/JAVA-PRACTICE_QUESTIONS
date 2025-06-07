package BackTracking;

import java.util.ArrayList;

public class FourDMazeProblem {
    public static void main(String[] args) {
        int row = 3;
        int col = 3;
        int[][] maze = new int[row][col];
        boolean[][] isVis = new boolean[row][col];
        ArrayList<String> res = new ArrayList<>();

        printPaths(0,0,row-1,col-1,res,"",isVis);

        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
    }

    private static void printPaths(int sr, int sc, int er, int ec, ArrayList<String> res, String s, boolean[][] isVis) {
        if(sr < 0 || sc < 0 || sr > er || sc > ec || isVis[sr][sc]) return;
        if(sr == er && sc == ec){
            res.add(s);
            return;
        }
        isVis[sr][sc] = true;

        // go up
        printPaths(sr-1, sc-1, er, ec, res, s+"U", isVis);
        // go left
        printPaths(sr, sc-1, er, ec, res, s+"L", isVis);
        // go right
        printPaths(sr, sc+1, er, ec, res, s+"R", isVis);
        // go down
        printPaths(sr+1, sc, er, ec, res, s+"D", isVis);

        // this is backtracking as we are marking code back to false and in this way we can access all other paths.
        isVis[sr][sc] = false;
    }
}
