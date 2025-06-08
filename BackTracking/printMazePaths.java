package BackTracking;

import java.util.ArrayList;

public class printMazePaths {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        int row = 3;
        int col = 3;
        int[][] maze = new int[row][col];

        ArrayList<String> res = new ArrayList<>();

        printPaths(1,1,row,col,res,"");

        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
    }

    private static void printPaths(int sr, int sc, int er, int ec, ArrayList<String> res, String s) {
        if(sr == er && sc == ec) res.add(s);
        if(sr>er || sc>ec) return;

        printPaths(sr+1, sc, er, ec, res, s+"D");
        printPaths(sr, sc+1, er, ec, res, s+"R");
    }

    
}
