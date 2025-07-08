package DP;
import java.util.Arrays;

public class stocksBuyandSellWithTransactions {
    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;

        int[][] dp = new int[prices.length+1][2];
        for(int[] row: dp) Arrays.fill(row,-1);
        System.out.println("Memoization answer: "+ profitMade(0,1,prices, dp, fee));

        int[][] dp2 = new int[prices.length+1][2];
        System.out.println("Tabulation answer: "+ tabulation(prices, dp2, fee));

        System.out.println("Space Optimized answer: "+ spaceOptimization(prices, fee));
    }

    public static int spaceOptimization(int[] prices, int fee){
        int n = prices.length;

        int aheadBuy , aheadNotBuy , currBuy , currNotBuy = 0;
        aheadBuy = aheadNotBuy = 0;
        for(int i=n-1;i>=0;i--){
            currNotBuy = Math.max(prices[i] - fee + aheadBuy , aheadNotBuy);
            currBuy = Math.max(-prices[i] + aheadNotBuy , aheadBuy);

            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }

        return aheadBuy;
    }

    public static int tabulation(int[] prices, int[][] dp, int fee){
        int n = prices.length;
        dp[n][0] = dp[n][1] = 0;

        for(int idx= n-1;idx>=0;idx--){
            for(int buy =0;buy<=1;buy++){
                int profit = 0;
                if(buy==1){
                    profit = Math.max((-prices[idx] + dp[idx+1][0]) , dp[idx+1][1]);
                }
                else{
                    profit = Math.max((prices[idx] - fee + dp[idx+1][1]) , dp[idx+1][0]);
                }
                dp[idx][buy] = profit;
            }
        }

        return dp[0][1];
    }

    public static int profitMade(int day , int buy , int[] prices, int[][] dp, int fee){
        if(day == prices.length) return 0;
        if(dp[day][buy] != -1) return dp[day][buy];
        int profit = 0;
        if(buy==1){
            profit = Math.max((-prices[day] + profitMade(day+1 , 0, prices, dp, fee)) , profitMade(day+1 , 1, prices, dp, fee));
        }
        else{
            profit = Math.max((prices[day] - fee + profitMade(day+1 , 1 , prices, dp, fee)) , profitMade(day+1 , 0 , prices, dp, fee));
        }

        return dp[day][buy] = profit;
    }
}
