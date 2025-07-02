package DP;
import java.util.*;

public class Knapsack {

    static int knapsack(int W, int val[], int wt[]) {
        // int[][] dp = new int[val.length+1][W+1];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return maximum(val.length-1, W, val, wt, dp);

        // int[][] dp2 = new int[val.length][W + 1];
        // return tabulate(val.length, W, val, wt, dp2);

        return spaceOptimized(val.length, W, val, wt);
    }

    static int spaceOptimized(int n, int W, int[] val, int[] wt){
        int[] prev = new int[W+1];
        for (int target = 0; target <= W; target++) {
            if (wt[0] <= target) prev[target] = val[0];
            else prev[target] = 0;
        }

        for(int i=1;i<n;i++){
            int[] curr = new int[W+1];
            for(int target=0;target<=W;target++){
                int not_pick = prev[target];
                int pick = 0;

                if (wt[i] <= target) pick = val[i] + prev[target - wt[i]];

                curr[target] = Math.max(not_pick, pick);
            }
            prev = curr;
        }
        return prev[W];
    }

    static int maximum(int n, int W, int[] val, int[] wt, int[][] dp){
        if(dp[n][W] != -1) return dp[n][W];
        if(n==0){
            if(wt[0] <= W) return val[0];
            return 0;
        }
        
        int not_pick = 0 + maximum(n-1 , W, val, wt,dp);
        int pick = Integer.MIN_VALUE;
        
        if(wt[n] <= W) pick = val[n] + maximum(n-1, (W-wt[n]) , val, wt, dp);
        
        return dp[n][W] = Math.max(not_pick , pick);
    }

    static int tabulate(int n, int W, int[] val, int[] wt, int[][] dp) {
        for (int target = 0; target <= W; target++) {
            if (wt[0] <= target) dp[0][target] = val[0];
            else dp[0][target] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= W; target++) {
                int not_pick = dp[i - 1][target];
                int pick = 0;

                if (wt[i] <= target) pick = val[i] + dp[i - 1][target - wt[i]];

                dp[i][target] = Math.max(not_pick, pick);
            }
        }

        return dp[n - 1][W];
    }

    public static void main(String[] args) {
        int W = 7;
        int[] val = {10,8,6};
        int[] wt = {1 , 7, 9};

        System.out.println("Maximum value in Knapsack: " + knapsack(W, val, wt));
    }
}
