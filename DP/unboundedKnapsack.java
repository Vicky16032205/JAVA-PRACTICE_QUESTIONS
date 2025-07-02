package DP;

// import java.util.*;

public class unboundedKnapsack {
    public static void main(String[] args) {
        int[] val = {1,1};
        int[] wt = {2,1};
        int capacity = 3;

        System.out.println(knapsack(val,wt,capacity));
    }

    static int knapsack(int val[], int wt[], int capacity){
        // int[][] dp = new int[val.length+1][capacity+1];
        // for(int[] row : dp) Arrays.fill(row, -1);
        // return repetition(val.length-1, capacity, val, wt, dp);

        // int[][] dp2 = new int[val.length][capacity+1];
        // return tabulation(val.length, capacity , val, wt, dp2);

        // return space(val.length, capacity, val , wt);
        return moreOptimized(val.length, capacity, val , wt);
    }

    static int moreOptimized(int n, int W, int[] val, int[] wt){
        int[] prev = new int[W+1];
        
        for(int i=0;i<=W;i++){
            if(wt[0] <= i) prev[i] = (i/wt[0])*val[0];
            else prev[i] = 0;
        }

        for(int i=1;i<n;i++){
            for(int target=0;target<=W;target++){
                int not_pick = 0 + prev[target];
                int pick = Integer.MIN_VALUE;
                if(wt[i] <= target) pick = val[i] + prev[target-wt[i]];
                
                prev[target] = Math.max(not_pick, pick);
            }
        }
        
        return prev[W];
    }

    static int space(int n, int W, int[] val, int[] wt){
        int[] prev = new int[W+1];
        
        for(int i=0;i<=W;i++){
            if(wt[0] <= i) prev[i] = (i/wt[0])*val[0];
            else prev[i] = 0;
        }
        
        for(int i=1;i<n;i++){
            
            int[] curr = new int[W+1];
            
            for(int target=0;target<=W;target++){
                int not_pick = 0 + prev[target];
                int pick = Integer.MIN_VALUE;
                if(wt[i] <= target) pick = val[i] + curr[target-wt[i]];
                
                curr[target] = Math.max(not_pick, pick);
            }
            prev = curr;
        }
        
        return prev[W];
    }

    static int tabulation(int n, int W, int[] val, int[] wt, int[][] dp){
        for(int i=0;i<=W;i++){
            if(wt[0] <= i) dp[0][i] = (i/wt[0])*val[0];
            else dp[0][i] = 0;
        }
        
        for(int i=1;i<n;i++){
            for(int target=0;target<=W;target++){
                int not_pick = 0 + dp[i-1][target];
                int pick = Integer.MIN_VALUE;
                if(wt[i] <= target) pick = val[i] + dp[i][target-wt[i]];
                
                dp[i][target] = Math.max(not_pick, pick);
            }
        }
        
        return dp[n-1][W];
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
