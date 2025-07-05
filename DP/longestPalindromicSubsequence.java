package DP;

import java.util.Arrays;

public class longestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "bbbab";
        String t = new StringBuilder(s).reverse().toString();

        System.out.println("Recursive solution: " + palindrome(s.length()-1 , t.length()-1 , s, t));
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int[] row : dp) Arrays.fill(row , -1);
        System.out.println("Memoization solution: " + memoization(s.length()-1 , t.length()-1 , s, t , dp));

        int[][] dp2 = new int[s.length()+1][t.length()+1];
        System.out.println("Tabulation solution: " + tabulation(s.length() , t.length() , s, t , dp2));

        System.out.println("Space Optimized solution: " + spaceOptimize(s.length() , t.length() , s, t ));
    }

    public static int spaceOptimize(int idx1 , int idx2 , String s, String t ){
        int[] prev = new int[idx1+1];

        for(int i=0;i<idx1;i++){
            prev[i] = 0;
        }

        for(int i=1;i<=idx1;i++){
            int[] curr = new int[idx2+1];
            for(int j=1;j<=idx2;j++){
                if(s.charAt(i-1) == t.charAt(j-1)) curr[j] = 1 + prev[j-1];
                else curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = curr;
        }
        return prev[s.length()];
    }

    public static int tabulation(int idx1 , int idx2 , String s, String t , int[][] dp){
        for(int i=0;i<=s.length();i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }

        for(int i=1;i<=s.length();i++){
            for(int j =1; j<=t.length();j++){
                if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return dp[s.length()][t.length()];
    }

    public static int memoization(int idx1 , int idx2 , String s, String t , int[][] dp){
        if(idx1 < 0 || idx2 < 0) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if(s.charAt(idx1) == t.charAt(idx2)){
            return dp[idx1][idx2] = 1 + memoization(idx1-1, idx2-1, s, t, dp);
        }
        return dp[idx1][idx2] = Math.max(memoization(idx1-1, idx2, s, t, dp) , memoization(idx1, idx2-1, s, t, dp));
    }

    private static int palindrome(int idx1 , int idx2 , String s, String t){
        if(idx1 < 0 || idx2 < 0) return 0;
        if(s.charAt(idx1) == t.charAt(idx2)){
            return 1 + palindrome(idx1-1, idx2-1, s, t);
        }
        return Math.max(palindrome(idx1-1, idx2, s, t) , palindrome(idx1, idx2-1, s, t));
    }
}