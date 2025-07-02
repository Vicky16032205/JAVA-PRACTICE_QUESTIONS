package DP;

import java.util.Arrays;

public class coinChangeII {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;
        System.out.println(change(amount,coins));
    }

    public static int change(int amount, int[] coins) {
        // int[][] dp = new int[coins.length+1][amount+1];
        // for(int[] row : dp) Arrays.fill(row, -1);

        // int ans = changes(coins.length-1, amount, coins,dp);
        // int[][] dp2 = new int[coins.length][amount+1];
        // int ans = changesTabu(coins.length, amount, coins,dp2);
        int ans = spaceOptimize(coins.length, amount, coins);
        return ans;
    }

    public static int spaceOptimize(int n, int target, int[] arr){
        int[] prev = new int[target+1];

        for(int i=0;i<=target;i++){
            if(i%arr[0] == 0) prev[i] = 1;
            else prev[i] = 0;
        }

        for(int i=1;i<n;i++){
            int[] curr = new int[target+1];

            for(int T=0;T<=target;T++){
                int not_pick = prev[T];
                int pick = 0;
                if(arr[i] <= T) pick = curr[T-arr[i]];

                curr[T] =(not_pick + pick);
            }
            prev = curr;
        }
        return prev[target];
    }

    public static int changesTabu(int n, int target, int[] arr, int[][] dp){
        for(int i=0;i<=target;i++){
            if(i%arr[0] == 0) dp[0][i] = 1;
            else dp[0][i] = 0;
        }

        for(int i=1;i<n;i++){
            for(int T=0;T<=target;T++){
                int not_pick = dp[i-1][T];
                int pick = 0;
                if(arr[i] <= T) pick = dp[i][T-arr[i]];

                dp[i][T] =(not_pick + pick);
            }
        }
        return dp[n-1][target];
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