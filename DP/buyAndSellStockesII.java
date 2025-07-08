package DP;

import java.util.Arrays;

public class buyAndSellStockesII {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Buy and Sell stocks II problem of leetcode ways to solve the problem ==>");
        int[][] dp = new int[prices.length+1][2];
        for(int[] row: dp) Arrays.fill(row,-1);
        System.out.println("Using memoization: "+profitMade(0,1,prices, dp));

        int[][] dp2 = new int[prices.length+1][2];
        System.out.println("Using Tabulation: "+tabulation(prices, dp2));

        System.out.println("Optimizing space complexity: "+spaceOptimization(prices));
    }

    public static int spaceOptimization(int[] prices){
        int n = prices.length;

        int aheadBuy , aheadNotBuy , currBuy , currNotBuy = 0;
        aheadBuy = aheadNotBuy = 0;
        for(int i=n-1;i>=0;i--){
            currNotBuy = Math.max(prices[i] + aheadBuy , aheadNotBuy);
            currBuy = Math.max(-prices[i] + aheadNotBuy , aheadBuy);

            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }

        return aheadBuy;
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

    public static int tabulation(int[] prices, int[][] dp){
        int n = prices.length;
        dp[n][0] = dp[n][1] = 0;

        for(int idx= n-1;idx>=0;idx--){
            for(int buy =0;buy<=1;buy++){
                int profit = 0;
                if(buy==1){
                    profit = Math.max((-prices[idx] + dp[idx+1][0]) , dp[idx+1][1]);
                }
                else{
                    profit = Math.max((prices[idx] + dp[idx+1][1]) , dp[idx+1][0]);
                }
                dp[idx][buy] = profit;
            }
        }

        return dp[0][1];
    }
}
