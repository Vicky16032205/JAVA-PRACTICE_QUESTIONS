package DP;

import java.util.Arrays;

public class coinChangeII {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;
        System.out.println(change(amount,coins));
    }

    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] row : dp) Arrays.fill(row, -1);

        int ans = changes(coins.length-1, amount, coins,dp);
        return ans;
    }

    public static int changes(int n, int target, int[] arr, int[][] dp){
        if(dp[n][target] != -1) return dp[n][target];
        if(n==0){
            return (target%arr[0] == 0)?1:0;
        }
        int not_pick = changes(n-1,target, arr, dp);
        int pick = 0;
        if(arr[n] <= target) pick = changes(n, target-arr[n] , arr, dp);

        return dp[n][target] =(not_pick + pick);
    }
}