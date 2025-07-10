package DP;

import java.util.Arrays;

public class longestDivisibleSubsequence {
    public static void main(String[] args) {
        int[] nums = {13,7,5,3};
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        LDS(nums, dp);
    }

    public static void LDS(int[] nums , int[] dp){
        int maxi = 1;
        int idx = -1;

        int[] hash = new int[nums.length];
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i] % nums[j] == 0 && dp[i] < 1+dp[j]){
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if(maxi < dp[i]){
                maxi = dp[i];
                idx = i;
            }
        }

        if(idx == -1){
            System.out.println("Not possible");
            return;
        }

        int[] ans = new int[maxi];

        for(int i=0;i<maxi;i++){
            ans[i] = nums[idx];
            idx = hash[idx];
        }

        for(int i=maxi-1;i>=0;i--){
            System.out.print(ans[i]+" ");
        }
    }
}
