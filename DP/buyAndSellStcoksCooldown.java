package DP;
import java.util.Arrays;

public class buyAndSellStcoksCooldown {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};

        int[][] dp = new int[prices.length+1][2];
        for(int[] row: dp) Arrays.fill(row,-1);
        System.out.println("Memoization: "+profitMade(0,1,prices, dp));

        int[][] dp2 = new int[prices.length+2][2];
        System.out.println("Tabulation: "+ tabulation(prices, dp2));
    }

    public static int profitMade(int day , int buy , int[] prices, int[][] dp){
        if(day >= prices.length) return 0;
        if(dp[day][buy] != -1) return dp[day][buy];
        int profit = 0;
        if(buy==1){
            profit = Math.max((-prices[day] + profitMade(day+1 , 0, prices, dp)) , profitMade(day+1 , 1, prices, dp));
        }
        else{
            profit = Math.max((prices[day] + profitMade(day+2 , 1 , prices, dp)) , profitMade(day+1 , 0 , prices, dp));
        }

        return dp[day][buy] = profit;
    }

    public static int tabulation(int[] prices, int[][] dp){
        int n = prices.length;
        dp[n][0] = dp[n][1] = 0;
        dp[n+1][0] = 0;

        for(int idx= n-1;idx>=0;idx--){
            for(int buy =0;buy<=1;buy++){
                int profit = 0;
                if(buy==1){
                    profit = Math.max((-prices[idx] + dp[idx+1][0]) , dp[idx+1][1]);
                }
                else{
                    profit = Math.max((prices[idx] + dp[idx+2][1]) , dp[idx+1][0]);
                }
                dp[idx][buy] = profit;
            }
        }

        return dp[0][1];
    }
}
