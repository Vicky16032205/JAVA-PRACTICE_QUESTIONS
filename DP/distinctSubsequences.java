package DP;

import java.util.Arrays;

public class distinctSubsequences {
    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";

        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        System.out.println("Total recursive matching: "+ recursion(s.length(), t.length(),s,t));
        System.out.println("Total recursive matching using memoization: "+ memoization(s.length(), t.length(),s,t, dp));
    }

    public static int memoization(int idx1 ,int idx2 ,String s ,String t, int[][] dp){
        if(idx2 == 0) return 1;
        if(idx1 ==0) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if(s.charAt(idx1-1) == t.charAt(idx2-1)){
            return dp[idx1][idx2] = memoization(idx1-1, idx2-1, s, t, dp) + memoization(idx1-1, idx2, s, t, dp);
        }
        return dp[idx1][idx2] = memoization(idx1-1, idx2, s, t, dp);
    }

    public static int recursion(int idx1 ,int idx2 ,String s ,String t){
        if(idx2 == 0) return 1;
        if(idx1 ==0) return 0;

        if(s.charAt(idx1-1) == t.charAt(idx2-1)){
            return recursion(idx1-1, idx2-1, s, t) + recursion(idx1-1, idx2, s, t);
        }
        return recursion(idx1-1, idx2, s, t);
    }
}
