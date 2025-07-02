package DP;

public class Knapsack {

    static int knapsack(int W, int val[], int wt[]) {
        int[][] dp2 = new int[val.length][W + 1];
        return tabulate(val.length, W, val, wt, dp2);
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
