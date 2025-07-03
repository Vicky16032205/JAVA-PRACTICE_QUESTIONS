package DP;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "acd";
        String str2 = "aec";
        System.out.println("Recursive solution: " + recursive(str1.length()-1 , str2.length()-1 , str1 , str2));

        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        System.out.println("Memoization solution: " + memoize(str1.length() , str2.length() , str1 , str2, dp));

        int[][] dp2 = new int[str1.length()+1][str2.length()+1];
        System.out.println("Tabulation solution: " + tabulation(str1.length() , str2.length() , str1 , str2, dp2));
    }

    public static int tabulation(int idx1 , int idx2, String str1 , String str2, int[][] dp){
        for(int i=0;i<=str1.length();i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=str2.length();i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return dp[str1.length()][str2.length()];
    }

    public static int memoize(int idx1 , int idx2, String str1 , String str2, int[][] dp){
        // if(idx1 <0 || idx2 < 0) return 0;
        // if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        // if(str1.charAt(idx1) == str2.charAt(idx2)) return dp[idx1][idx2] = 1 + memoize(idx1-1, idx2-1, str1, str2, dp);
        // return dp[idx1][idx2] = Math.max(memoize(idx1-1, idx2, str1, str2, dp) , memoize(idx1, idx2-1, str1, str2, dp));

        if(idx1 == 0 || idx2 == 0) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if(str1.charAt(idx1-1) == str2.charAt(idx2-1)) return dp[idx1][idx2] = 1 + memoize(idx1-1, idx2-1, str1, str2, dp);
        return dp[idx1][idx2] = Math.max(memoize(idx1-1, idx2, str1, str2, dp) , memoize(idx1, idx2-1, str1, str2, dp));
    }

    public static int recursive(int idx1 , int idx2, String str1 , String str2){
        if(idx1 <0 || idx2 < 0) return 0;

        if(str1.charAt(idx1) == str2.charAt(idx2)) return 1 + recursive(idx1-1, idx2-1, str1, str2);
        return Math.max(recursive(idx1-1, idx2, str1, str2) , recursive(idx1, idx2-1, str1, str2));
    }
}
