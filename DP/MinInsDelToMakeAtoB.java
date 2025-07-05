package DP;

public class MinInsDelToMakeAtoB {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        String t = "geeks";

        int[][] dp = new int[s.length()+1][t.length()+1];
        int lcs = lcs(s.length(), t.length(), s,t, dp);
        int ans = s.length() + t.length() - 2*lcs;
        System.out.println("Minimum insertions and deletions required is: "+ ans);
    }

    public static int lcs(int idx1 , int idx2 , String s , String t , int[][] dp){
        for(int i=0;i<=idx1;i++){
            dp[i][0] = 0;
        }
        
        for(int i=0;i<=idx2;i++){
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
}
