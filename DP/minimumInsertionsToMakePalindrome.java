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
       System.out.println("Minimum Insertions required using memoization = "+ (s.length()- ans1));

       int[][] dp2 = new int[s.length()+1][t.length()+1];
       int ans2 = tabulation(s.length() , t.length() , s , t , dp2);
       System.out.println("Minimum Insertions required using tabulation = "+ (s.length()- ans2));
    }

    public static int tabulation(int idx1, int idx2 , String s  , String t , int[][] dp){
        for(int i=0;i<=idx1;i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }

        for(int i=1;i<=idx1;i++){
            for(int j=1;j<=idx2;j++){
                if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return dp[s.length()][t.length()];
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
