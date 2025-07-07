package DP;

public class wildcardMatching {
    public static void main(String[] args) {
        String s = "*a*b";
        String t = "adceb";

        System.out.println("Recursive answer: " + possible(s.length()-1 , t.length()-1 , s, t));

        Boolean[][] dp = new Boolean[s.length()+1][t.length()+1];
        System.out.println("Memoization answer: " + memoization(s.length()-1 , t.length()-1 , s, t, dp));

        boolean[][] dp2 = new boolean[s.length()+1][t.length()+1];
        System.out.println("Tabulation answer: " + tabulation(s.length() , t.length() , s, t, dp2));
    }

    public static boolean tabulation(int idx1 ,int idx2 ,String s, String t, boolean[][] dp){
        dp[0][0] = true;

        for(int i=1;i<=idx1;i++){
            boolean flag = true;
            for(int ii=1;ii<=i;ii++){
                if(s.charAt(ii-1) != '*'){
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }

        for(int i=1;i<=idx1;i++){
            for(int j=1;j<=idx2;j++){
                if(s.charAt(i-1) == t.charAt(j-1) || s.charAt(i-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                if(s.charAt(i-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[idx1][idx2];
    }

    public static boolean memoization(int idx1, int idx2, String s , String t, Boolean[][] dp){
        if(idx1 < 0 && idx2 < 0) return true;
        if(idx1 < 0) return false;
        if(idx2 < 0){
            for(int i=0;i<=idx1;i++){
                if(s.charAt(i) != '*') return false;
            }
            return true;
        }

        if(dp[idx1][idx2] != null) return dp[idx1][idx2];

        if(s.charAt(idx1) == t.charAt(idx2) || s.charAt(idx1) == '?'){
            return dp[idx1][idx2] = memoization(idx1-1, idx2-1, s, t, dp);
        }

        if(s.charAt(idx1) == '*'){
            return dp[idx1][idx2] = memoization(idx1-1, idx2, s, t, dp) || memoization(idx1, idx2-1, s, t, dp);
        }
        return dp[idx1][idx2] = false;
    }

    public static boolean possible(int idx1, int idx2, String s , String t){
        if(idx1 < 0 && idx2 < 0) return true;
        if(idx1 < 0){
            return false;
        }
        if(idx2 < 0){
            for(int i=0;i<=idx1;i++){
                if(s.charAt(i) != '*') return false;
            }
            return true;
        }

        if(s.charAt(idx1) == t.charAt(idx2) || s.charAt(idx1) == '?'){
            return possible(idx1-1, idx2-1, s, t);
        }

        else if(s.charAt(idx1) == '*'){
            return possible(idx1-1, idx2, s, t) || possible(idx1, idx2-1, s, t);
        }
        return false;
    }
}
