package DP;

import java.util.Arrays;

public class minimumInsertionsToMakePalindrome {
    public static void main(String[] args) {
        String s = "abcaa";
        String t = new StringBuilder(s).reverse().toString();

       int ans = recursive(s.length()-1, t.length()-1 , s ,t);
       System.out.println("Minimum Insertions required using recursion= "+ (s.length()- ans));

       int[][] dp = new int[s.length()+1][t.length()+1];
       for(int[] row : dp) Arrays.fill(row, -1);
       int ans1 = memoization(s.length()-1 , t.length()-1 , s , t , dp);
       System.out.println("Minimum Insertions required using tabulation = "+ (s.length()- ans1));
    }

    public static int memoization(int idx1, int idx2 , String s  , String t , int[][] dp){
        if(idx1 < 0 || idx2 <0) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        if(s.charAt(idx1) == t.charAt(idx2)){
            return dp[idx1][idx2] = 1 + recursive(idx1-1, idx2-1, s, t);
        }
        return dp[idx1][idx2] = Math.max(recursive(idx1-1, idx2, s, t) , recursive(idx1, idx2-1, s, t));
    }

    public static int recursive(int idx1 , int idx2, String s , String t){
        if(idx1 < 0 || idx2 <0) return 0;
        if(s.charAt(idx1) == t.charAt(idx2)){
            return 1 + recursive(idx1-1, idx2-1, s, t);
        }
        return Math.max(recursive(idx1-1, idx2, s, t) , recursive(idx1, idx2-1, s, t));
    }
}
