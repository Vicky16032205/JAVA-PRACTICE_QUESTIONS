package DP;

import java.util.Arrays;

public class longestIncreasingSubsequence {

    public static int spaceOptimize(int n, int[] nums){
        int[] after = new int[n+1];
        for(int idx=n-1;idx>=0;idx--){
            int[] curr = new int[n+1];
            for(int prev_idx=idx-1;prev_idx>=-1;prev_idx--){
                int not_pick = after[prev_idx+1];
                int pick = Integer.MIN_VALUE;
                if(prev_idx == -1 || nums[idx] > nums[prev_idx]){
                    pick = 1 + after[idx+1];
                }
                curr[prev_idx+1] = Math.max(pick , not_pick);
            }
            after = curr;
        }
        return after[0];
    }

    public static int tabulate(int n , int[] nums, int[][] dp){
        for(int idx=n-1;idx>=0;idx--){
            for(int prev_idx = idx-1;prev_idx>=-1;prev_idx--){
                int not_pick = dp[idx+1][prev_idx+1];
                int pick = Integer.MIN_VALUE;
                if(prev_idx == -1 || nums[idx] > nums[prev_idx]){
                    pick = 1 + dp[idx+1][idx+1];
                }
                dp[idx][prev_idx+1] = Math.max(pick , not_pick);
            }
        }
        return dp[0][0];
    }

    public static int increase(int idx , int prev_idx , int[] nums, int[][] dp){
        if(idx == nums.length) return 0;
        
        if(dp[idx][prev_idx+1] != -1) return dp[idx][prev_idx+1];

        int not_pick = increase(idx+1 , prev_idx , nums, dp);
        int pick = Integer.MIN_VALUE;
        if(prev_idx == -1 || nums[idx]>nums[prev_idx]){
            pick = 1 + increase(idx+1 ,idx, nums, dp);
        }
        return dp[idx][prev_idx+1] = Math.max(not_pick , pick);
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int[][] dp = new int[nums.length][nums.length+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        System.out.println("memoized answer: "+increase(0, -1, nums, dp));

        int[][] dp2 = new int[nums.length+1][nums.length+1];
        System.out.println("tabulated answer: "+tabulate(nums.length, nums, dp2));
        

        System.out.println("space optimized answer: "+spaceOptimize(nums.length , nums));
    }
}
