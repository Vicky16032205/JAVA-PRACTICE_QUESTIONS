package DP;

public class longestCommonSubstring {
    static int ans =0;
    public static void main(String[] args) {
        String s = "abzd";
        String t = "abcd";

        System.out.println("Recursive answer " + common(s.length()-1 , t.length()-1 , s , t , 0));
        int[][] dp = new int[s.length()+1][t.length()+1];
        System.out.println("Memoization answer " + memoize(s.length()-1 , t.length()-1 , s , t , 0, dp));

        int[][] dp2 = new int[s.length()+1][t.length()+1];
        System.out.println("Tabulation answer " + tabulation(s.length() , t.length() , s , t ,dp2));

        System.out.println("Space optimization answer " + space(s.length() , t.length() , s , t));
    }

    public static int space(int idx1, int idx2,  String s, String t){
        int[] prev = new int[idx1+1];
        for(int i=0;i<=idx1;i++){
            prev[0] = 0;
        }
        int res = 0;
        for(int i=1;i<=idx1;i++){
            int[] curr = new int[idx2+1];

            for(int j=1;j<=idx2;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    curr[j] = prev[j-1] + 1;
                    res = Math.max(res,curr[j]);
                }
                else curr[j] = 0;
            }
            prev = curr;
        }
        return res;
    }


    public static int tabulation(int idx1, int idx2,  String s, String t, int[][] dp){
        for(int i=0;i<=idx1;i++){
            dp[i][0] = 0;
        }

        int res = 0;
        for(int i=1;i<=idx1;i++){
            for(int j=1;j<=idx2;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(res,dp[i][j]);
                }
                else dp[i][j] = 0;
            }
        }
        return res;
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
