package DP;

import java.util.Arrays;

public class buyAndSellStockesII {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        for(int[] row: dp) Arrays.fill(row,-1);
        return profitMade(0,1,prices, dp);
    }

    public static int profitMade(int day , int buy , int[] prices, int[][] dp){
        if(day == prices.length) return 0;
        if(dp[day][buy] != -1) return dp[day][buy];
        
        int profit = 0;
        if(buy==1){
            profit = Math.max((-prices[day] + profitMade(day+1 , 0, prices, dp)) , profitMade(day+1 , 1, prices, dp));
        }
        else{
            profit = Math.max((prices[day] + profitMade(day+1 , 1 , prices, dp)) , profitMade(day+1 , 0 , prices, dp));
        }

        return dp[day][buy] = profit;
    }
}
