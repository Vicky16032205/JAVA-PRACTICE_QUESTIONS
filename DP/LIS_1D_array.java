package DP;

import java.util.Arrays;

public class LIS_1D_array {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        
        System.out.println(Nsq(nums, dp));
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp2,1);
        printLIS(nums, dp2);
    }

    public static void printLIS(int[] nums, int[] dp){
        int maxi = 1;
        int idx =-1;
        int[] hash = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j] && dp[i] < 1+dp[j]){
                    dp[i] = 1+dp[j];
                    hash[i] = j;
                    maxi = Math.max(maxi , dp[i]);
                }
            }
        }

        for(int i=0;i<hash.length;i++){
            if(idx<hash[i]) idx = i;
        }

        int[] ans = new int[maxi];
        for(int i=0;i<maxi;i++){
            ans[i] = nums[idx];
            idx = hash[idx];
        }

        for(int i=ans.length-1;i>=0;i--){
            System.out.print(ans[i]+" ");
        }
    }

    public static int Nsq(int[] nums , int[] dp){
        int maxi = 1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i] , 1 + dp[j]);
                    maxi = Math.max(maxi , dp[i]);
                }
            }
        }
        return maxi;
    }
}
