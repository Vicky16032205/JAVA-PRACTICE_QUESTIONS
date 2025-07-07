package DP;

public class wildcardMatching {
    public static void main(String[] args) {
        String s = "m??*ss*?i*pi";
        String t = "mississippi";

        System.out.println("Recursive answer: " + possible(s.length()-1 , t.length()-1 , s, t));

        Boolean[][] dp = new Boolean[s.length()+1][t.length()+1];
        System.out.println("Memoization answer: " + memoization(s.length()-1 , t.length()-1 , s, t, dp));
    }

    public static boolean memoization(int idx1, int idx2, String s , String t, Boolean[][] dp){
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
