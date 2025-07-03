package DP;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "abcdef";
        System.out.println("Recursive solution: " + recursive(str1.length()-1 , str2.length()-1 , str1 , str2));

        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        System.out.println("Memoization solution: " + memoize(str1.length()-1 , str2.length()-1 , str1 , str2, dp));
    }

    public static int memoize(int idx1 , int idx2, String str1 , String str2, int[][] dp){
        if(idx1 <0 || idx2 < 0) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if(str1.charAt(idx1) == str2.charAt(idx2)) return dp[idx1][idx2] = 1 + memoize(idx1-1, idx2-1, str1, str2, dp);
        return dp[idx1][idx2] = Math.max(memoize(idx1-1, idx2, str1, str2, dp) , memoize(idx1, idx2-1, str1, str2, dp));
    }

    public static int recursive(int idx1 , int idx2, String str1 , String str2){
        if(idx1 <0 || idx2 < 0) return 0;

        if(str1.charAt(idx1) == str2.charAt(idx2)) return 1 + recursive(idx1-1, idx2-1, str1, str2);
        return Math.max(recursive(idx1-1, idx2, str1, str2) , recursive(idx1, idx2-1, str1, str2));
    }
}
