package DP;

import java.util.*;

public class unboundedKnapsack {
    public static void main(String[] args) {
        int[] val = {1,1};
        int[] wt = {2,1};
        int capacity = 3;

        System.out.println(knapsack(val,wt,capacity));
    }

    static int knapsack(int val[], int wt[], int capacity){
        int[][] dp = new int[val.length+1][capacity+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return repetition(val.length-1, capacity, val, wt, dp);
    }

    static int repetition(int n, int W, int[] val, int[] wt, int[][] dp){
        if(dp[n][W] != -1) return dp[n][W];
        if(n==0){
            if(wt[0] <= W) return (W/wt[0])*val[0];
            return 0;
        }
        
        int not_pick = 0 + repetition(n-1,W,val,wt, dp);
        int pick = Integer.MIN_VALUE;
        if(wt[n] <= W) pick = val[n] + repetition(n,(W-wt[n]), val,wt, dp);
        
        return dp[n][W] = Math.max(not_pick , pick);
    }
}
