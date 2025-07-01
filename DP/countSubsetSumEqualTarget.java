package DP;

import java.util.*;

public class countSubsetSumEqualTarget {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        int[] arr = {1,4,4,5};
        int target = 5;
        int[][] dp = new int[arr.length+1][target+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        System.out.println("Recursive answer: " +countWays(arr,target, arr.length-1));
        System.out.println("Memoization answer: " +countWays2(arr,target, arr.length-1,dp));
        int[][] dp2 = new int[arr.length][target+1];
        System.out.println("Tabulation answer: " +countWays3(arr,target, arr.length-1,dp2));
    }

    private static int countWays(int[] arr, int k, int n) {
        if(n<0) return 0;
        if(n==0) {
            if(k == 0 && arr[0] == 0) return 2;
            if(k == 0 || arr[0] == k) return 1;
            return 0;
        }
        int not_pick = countWays(arr, k,n-1);
        int pick = 0;
        if(arr[n] <= k) pick = countWays(arr, k-arr[n], n-1);
        return (not_pick + pick);
    }

    private static int countWays2(int[] arr, int k, int n, int[][] dp) {
        if(n<0) return 0;
        if(n==0) {
            if(k == 0 && arr[0] == 0) return 2;
            if(k == 0 || arr[0] == k) return 1;
            return 0;
        }
        if(dp[n][k] != -1) return dp[n][k];


        int not_pick = countWays2(arr, k,n-1,dp) % MOD;
        int pick = 0;

        if(arr[n] <= k) pick = countWays2(arr, k-arr[n], n-1,dp) % MOD;

        dp[n][k] = (pick + not_pick) % MOD;

        return dp[n][k];
    }

    public static int countWays3(int[] arr, int k, int n, int[][] dp){
        return 0;
    }
}
