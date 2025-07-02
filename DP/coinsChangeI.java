package DP;

import java.util.*;

@SuppressWarnings("unused")
public class coinsChangeI {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }

    public static int coinChange(int[] coins, int amount) {
        // int[][] dp = new int[coins.length][amount+1];
        // for(int[] row : dp) Arrays.fill(row, -1);
        // int ans = changes(coins.length-1, amount, coins,dp);
        // int ans = tabulation(coins.length, amount, coins,dp);
        int ans = spaceOptimize(coins.length,amount,coins);

        if(ans >= Integer.MAX_VALUE - 100) return -1;
        return ans;
    }

    public static int spaceOptimize(int n, int T, int[] arr){
        int[] prev = new int[T+1];

        for(int i=0;i<=T;i++){
            if(i % arr[0] == 0) prev[i] = i/arr[0];
            else prev[i] = Integer.MAX_VALUE;
        }

        for(int i=1;i<n;i++){
            int[] curr = new int[T+1];

            for(int target =0;target<=T;target++){
                int not_pick = 0 + prev[target];
                int pick = Integer.MAX_VALUE;

                if(arr[i] <= target && curr[target-arr[i]] !=Integer.MAX_VALUE){
                    pick = 1 + curr[target-arr[i]];
                }

                curr[target] = Math.min(not_pick , pick);
            }
            prev = curr;
        }
        return prev[T];
    }

    public static int tabulation(int n, int T, int[] arr, int[][] dp){
        for(int i=0;i<=T;i++){
            if(i % arr[0] == 0) dp[0][i] = i/arr[0];
            else dp[0][i] = Integer.MAX_VALUE;
        }

        for(int i=1;i<n;i++){
            for(int target =0;target<=T;target++){
                int not_pick = 0 + dp[i-1][target];
                int pick = Integer.MAX_VALUE;

                if(arr[i] <= target && dp[i][target-arr[i]] !=Integer.MAX_VALUE){
                    pick = 1 + dp[i][target-arr[i]];
                }

                dp[i][target] = Math.min(not_pick , pick);
            }
        }
        return dp[n-1][T];
    }

    public static int changes(int n, int target, int[] arr, int[][] dp){
        if(dp[n][target] != -1) return dp[n][target];
        if(target == 0){
            if(n==0 && arr[0] == target) return 2;
            return 0;
        }
        if(n==0){
            if(target%arr[0] == 0) return (target/arr[0]);
            else return Integer.MAX_VALUE-100;
        }
        int not_pick = 0 + changes(n-1,target, arr, dp);
        int pick = Integer.MAX_VALUE;
        if(arr[n] <= target) pick = 1 + changes(n, target-arr[n] , arr, dp);

        return dp[n][target] = Math.min(not_pick, pick);
    }
}
