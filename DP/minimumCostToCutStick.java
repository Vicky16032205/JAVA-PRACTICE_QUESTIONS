package DP;

import java.util.Arrays;

public class minimumCostToCutStick {
    public static int tabulation(int[] arr, int[][] dp, int len){
        for(int i=len;i>=1;i--){
            for(int j=1;j<=len;j++){
                if(i>j) continue;
                int mini = Integer.MAX_VALUE;
                for(int idx=i;idx<=j;idx++){
                    int ans = (arr[j+1]-arr[i-1]) + dp[i][idx-1] + dp[idx+1][j];
                    mini = Math.min(mini, ans);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][len];
    }

    public static int miniCost(int[] arr, int i, int j, int[][] dp){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for(int idx=i;idx<=j;idx++){
            int ans = (arr[j+1]-arr[i-1]) + miniCost(arr,i,idx-1, dp) + miniCost(arr,idx+1, j, dp);
            mini = Math.min(mini, ans);
        }
        return dp[i][j] = mini;
    }

    public static void main(String[] args) {
        int n= 9;
        int[] cuts = {5,6,1,4,2};
        int len = cuts.length;
        int[] arr = new int[len+2];
        for(int i=0;i<len;i++){
            arr[i+1] = cuts[i];
        }
        arr[arr.length-1] = n;
        Arrays.sort(arr);

        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        System.out.println(miniCost(arr,1,arr.length-2, dp));
        
        int[][] dp2 = new int[arr.length+2][arr.length+2];
        System.out.println(tabulation(arr,dp2, len));
    }
}
