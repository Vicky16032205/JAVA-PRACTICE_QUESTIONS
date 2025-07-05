package DP;

public class shortestCommonSupersequence {
    public static void main(String[] args) {
        String s = "brute";
        String t = "groot";
        int[][] dp = new int[s.length()+1][t.length()+1];

        int ans = s.length() + t.length() - lcs(s.length(), t.length(), s,t, dp);
        System.out.println("Shortest Common subsequence length : "+ans);

        System.out.println("Shortest Common subsequence length : "+sequence(s.length(),t.length(),s,t,dp, ""));
    }

    public static String sequence(int idx1, int idx2, String s, String t, int[][] dp, String str){
        int i=idx1;
        int j = idx2;

        while(i>0 && j>0){
            if(s.charAt(i-1) == t.charAt(j-1)){
                str += s.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                str += s.charAt(i-1);
                i--;
            }
            else{
                str += t.charAt(j-1);
                j--;
            }
        }

        while(i>0){
            str += s.charAt(i-1);
            i--;
        }
        while (j>0) {
            str += t.charAt(j-1);
            j--;
        }
        return new StringBuilder(str).reverse().toString();
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
