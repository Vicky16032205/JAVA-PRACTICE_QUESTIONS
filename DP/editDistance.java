package DP;

import java.util.Arrays;

public class editDistance {
    public static void main(String[] args) {
        String s = "horse";
        String t = "ros";

        System.out.println("minimum operations required to convert string (s) to string (t) is : ==>");
        System.out.println("Using recursion: "+recursion(s.length()-1, t.length()-1 , s, t));

        // int[][] dp = new int[s.length()+1][t.length()+1];
        // for(int[] row : dp) Arrays.fill(row, -1);
        // System.out.println("Using memoization: "+ memoization(s.length()-1, t.length()-1 , s, t , dp));
    }



    public static int recursion(int idx1, int idx2, String s , String t){
        if(idx1 < 0) return idx2+1;
        if(idx2 < 0) return idx1+1;

        if(s.charAt(idx1) == t.charAt(idx2)) return 0 + recursion(idx1-1, idx2-1, s, t);

        int delete = 1 + recursion(idx1-1, idx2, s, t);
        int insert = 1 + recursion(idx1, idx2-1, s, t);
        int replace = 1 + recursion(idx1-1, idx2-1, s, t);

        return Math.min(delete , Math.min(insert , replace));
    }
}