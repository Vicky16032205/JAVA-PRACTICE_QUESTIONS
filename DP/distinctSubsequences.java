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

        int[][] dp2 = new int[s.length()+1][t.length()+1];
        System.out.println("Total recursive matching using tabulation: "+ tabulation(s.length(), t.length(),s,t, dp2));
    }

    public static int tabulation(int idx1 ,int idx2 ,String s ,String t, int[][] dp){
        // change base case to iterations and find its value
        for(int i=0;i<=idx1;i++){
            dp[i][0] = 1;         // not matter on what index of string1, value of size of string2 becomes 0 will give output as 1;
        }

        for(int j=1;j<=idx2;j++){
            dp[0][j] = 0;           // if at any index of string2, if the value of size of index1 becomes 0 will give output as 0; 
        }

        for(int i=1;i<=idx1;i++){
            for(int j=1;j<=idx2;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[idx1][idx2];
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
