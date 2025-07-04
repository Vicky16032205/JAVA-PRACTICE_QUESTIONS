package DP;

public class longestCommonSubstring {
    static int ans =0;
    public static void main(String[] args) {
        String s = "abcde";
        String t = "cdegabcde";

        System.out.println("Recursive answer " + common(s.length()-1 , t.length()-1 , s , t , 0));
        int[][] dp = new int[s.length()+1][t.length()+1];
        System.out.println("Memoization answer " + memoize(s.length()-1 , t.length()-1 , s , t , 0, dp));
    }

    public static int memoize(int idx1, int idx2,  String s, String t, int count , int[][] dp){
        if(idx1 <0 || idx2 <0) return ans;
        if(dp[idx1][idx2] != 0) return dp[idx1][idx2] ;
        if(s.charAt(idx1) == t.charAt(idx2)){
            count += 1;
            ans = Math.max(ans , count);
            return dp[idx1][idx2] = memoize(idx1-1, idx2-1, s, t, count, dp);
        }
        else{
            return dp[idx1][idx2] = Math.max(memoize(idx1-1, idx2, s, t, 0, dp) , memoize(idx1, idx2-1, s, t, 0, dp));
        }
    }

    public static int common(int idx1, int idx2,  String s, String t, int count){
        if(idx1 <0 || idx2<0) return ans;
        if(s.charAt(idx1) == t.charAt(idx2)){
            count += 1;
            ans = Math.max(ans , count);
            return common(idx1-1, idx2-1, s, t, count);
        }
        else{
            return Math.max(common(idx1-1, idx2, s, t, 0) , common(idx1, idx2-1, s, t, 0));
        }
    }
}
