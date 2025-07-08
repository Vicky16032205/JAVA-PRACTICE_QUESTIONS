package DP;

import java.util.Arrays;

class buyAndSellStocksIII {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};

        System.out.println("Buy and Sell stocks III problem of leetcode ways to solve the problem ==>");
        System.out.println("Using recursion: "+profitMade(0,1,prices,2));

        int[][][] dp = new int[prices.length+1][2][3];
        for(int[][] row : dp){
            for(int[] rows: row){
                Arrays.fill(rows, -1);
            }
        }
        System.out.println("Using memoization: "+memoization(0,1,prices,2, dp));

        int[][][] dp2 = new int[prices.length+1][2][3];
        System.out.println("Using tabulation: " + tabulation(prices, dp2));
    }

    private static int tabulation(int[] prices, int[][][] dp) {
        for(int idx=prices.length-1;idx>=0;idx--){
            for(int buy=0;buy<=1;buy++){
                for(int transactions= 1;transactions<=2;transactions++){
                    int profit = 0;
                    if(buy==1){
                        profit = Math.max(-prices[idx] + dp[idx+1][0][transactions] , dp[idx+1][1][transactions] );
                    }
                    else{
                        profit = Math.max(prices[idx] + dp[idx+1][1][transactions-1] , dp[idx+1][0][transactions]);
                    }

                    dp[idx][buy][transactions] = profit;
                }
            }
        }
        return dp[0][1][2];
    }

    private static int memoization(int idx, int buy, int[] prices, int transactions, int[][][] dp) {
        if(transactions == 0 || idx == prices.length) return 0;
        if(dp[idx][buy][transactions] != -1) return dp[idx][buy][transactions];
        
        int profit = 0;
        if(buy==1){
            profit = Math.max((-prices[idx] + memoization(idx+1, 0, prices, transactions, dp)) , memoization(idx+1, 1, prices, transactions, dp));
        }
        else{
            profit = Math.max((prices[idx] + memoization(idx+1, 1, prices, transactions-1 , dp)) , memoization(idx+1, 0, prices, transactions, dp));
        }

        return dp[idx][buy][transactions] = profit;
    }



    private static int profitMade(int idx, int buy, int[] prices, int transactions) {
        if(transactions == 0) return 0;
        if(idx == prices.length) return 0;
        
        int profit = 0;
        if(buy==1){
            profit = Math.max((-prices[idx] + profitMade(idx+1, 0, prices, transactions)) , profitMade(idx+1, 1, prices, transactions));
        }
        else{
            profit = Math.max((prices[idx] + profitMade(idx+1, 1, prices, transactions-1)) , profitMade(idx+1, 0, prices, transactions));
        }

        return profit;
    }

    
}
