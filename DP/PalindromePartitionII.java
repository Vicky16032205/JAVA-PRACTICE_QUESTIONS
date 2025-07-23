package DP;

import java.util.Arrays;

public class PalindromePartitionII {
    public static void main(String[] args) {
        String s = "bababcbadcede";

        int[] dp = new int[s.length()+1];
        Arrays.fill(dp , -1);
        System.out.println(partition(0, s, dp) - 1);

        int[] dp2 = new int[s.length()+1];
        System.out.println(tabulation(s, dp2)-1);
    }

    public static int tabulation(String s , int[] dp){
        for(int i=s.length()-1;i>=0;i--){
            int mini = Integer.MAX_VALUE;
            for(int j=i;j<s.length();j++){
                if(palindrome(i,j,s)){
                    int ans = 1 + dp[j+1];
                    mini = Math.min(ans, mini);
                }
            }
            dp[i] = mini;
        }
        return dp[0];
    }

    public static int partition(int i, String s, int[] dp){
        if(i==s.length()) return 0;
        if(dp[i] != -1) return dp[i];
        int mini = Integer.MAX_VALUE;

        for(int j=i;j<s.length();j++){
            if(palindrome(i,j,s)){
                int ans = 1 + partition(j+1,s, dp);
                mini = Math.min(ans, mini);
            }
        }
        return dp[i] = mini;
    }

    public static boolean palindrome(int i, int j, String s){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
