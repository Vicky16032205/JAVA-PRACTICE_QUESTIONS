package DP;

import java.util.Arrays;

public class editDistance {
    public static void main(String[] args) {
        String s = "intention";
        String t = "execution";

        System.out.println("minimum operations required to convert string (s) to string (t) is : ==>");
        System.out.println("Using recursion: "+recursion(s.length()-1, t.length()-1 , s, t));

        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        System.out.println("Using memoization: "+ memoization(s.length()-1, t.length()-1 , s, t , dp));

        int[][] dp2 = new int[s.length()+1][t.length()+1];
        System.out.println("Using tabulation: "+ tabulation(s.length(), t.length() , s, t , dp2));
    }

    public static int tabulation(int idx1 , int idx2 , String s , String t , int[][] dp){
        for(int i=0;i<=idx1;i++){
            dp[i][0] = i;
        }

        for(int j=0;j<=idx2;j++){
            dp[0][j] = j;
        }

        for(int i=1;i<=idx1;i++){
            for(int j=1;j<=idx2;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int insert = dp[i-1][j];
                    int delete = dp[i][j-1];
                    int replace = dp[i-1][j-1];

                    dp[i][j] = 1 + Math.min(insert , Math.min(delete , replace));
                }
            }
        }
        return dp[idx1][idx2];
    }

    public static int memoization(int idx1 , int idx2 , String s , String t , int[][] dp){
        if(idx1<0) return idx2+1;
        if(idx2<0) return idx1+1;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        
        if(s.charAt(idx1) == t.charAt(idx2)) return dp[idx1][idx2] = memoization(idx1-1 , idx2-1 , s, t , dp);

        int insert = memoization(idx1-1 , idx2 , s, t , dp);
        int delete = memoization(idx1 , idx2-1 , s, t, dp);
        int replace = memoization(idx1-1 , idx2-1 , s, t , dp);

        return dp[idx1][idx2] = 1 + Math.min(insert , Math.min(delete , replace));
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