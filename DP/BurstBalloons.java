package DP;

import java.util.Arrays;

public class BurstBalloons {
    public static int tabulation(int[] nums, int n, int[][] dp){
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j) continue;
                int maxi = 0;
                for(int idx=i;idx<=j;idx++){
                    int ans = nums[idx]*nums[i-1]*nums[j+1] + dp[i][idx-1] +dp[idx+1][j];
                    maxi = Math.max(ans, maxi);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }

    public static int maximum(int[] nums, int i , int j, int[][] dp){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int maxi = 0;
        for(int idx=i;idx<=j;idx++){
            int ans = nums[idx]*nums[i-1]*nums[j+1] + maximum(nums,i,idx-1,dp) + maximum(nums,idx+1,j,dp);
            maxi = Math.max(ans, maxi);
        }
        return dp[i][j] = maxi;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,5,8};
        int n = arr.length;
        int[] nums = new int[n+2];
        for(int i=0;i<n;i++){
            nums[i+1]= arr[i];
        }
        nums[0] = 1;
        nums[nums.length-1] = 1;

        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        System.out.println(maximum(nums, 1, n, dp));

        int[][] dp2 = new int[nums.length+2][nums.length+2];
        System.out.println(tabulation(nums, n, dp2));
    }
}
