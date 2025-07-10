package DP;

import java.util.Arrays;

public class LIS_1D_array {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        
        System.out.println(Nsq(nums, dp));
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
