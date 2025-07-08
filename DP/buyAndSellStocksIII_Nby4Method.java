package DP;

import java.util.Arrays;

public class buyAndSellStocksIII_Nby4Method {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println("Recursive: "+recursive(prices,0, 0 ));

        int[][] dp = new int[prices.length+1][4];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println("Memoization: "+memoization(prices, 0, 0, dp));

        int[][] dp2 = new int[prices.length+1][5];
        System.out.println("Tabulation: "+tabulation(prices, dp2));

        System.out.println("Space Optimization: "+space(prices));
    }

    public static int space(int[] prices){
        int n= prices.length;
        int[] after = new int[5];

        for(int idx=n-1;idx>=0;idx--){
            int[] curr = new int[5];
            for(int transactions =0;transactions<4;transactions++){
                int profit =0;
                if(transactions%2==0){
                    profit = Math.max((-prices[idx] + after[transactions+1]) , after[transactions]);
                }  
                else{
                    profit = Math.max((prices[idx] + after[transactions+1]) , after[transactions]);
                }
                curr[transactions] = profit;
            }
            after = curr;
        }
        return after[0];
    }

    private static int tabulation(int[] prices, int[][] dp){
        int n = prices.length;
        for(int idx=n-1;idx>=0;idx--){
            for(int transactions =0;transactions<4;transactions++){
                int profit =0;
                if(transactions%2==0){
                    profit = Math.max((-prices[idx] + dp[idx+1][transactions+1]) , dp[idx+1][transactions]);
                }  
                else{
                    profit = Math.max((prices[idx] + dp[idx+1][transactions+1]) , dp[idx+1][transactions]);
                }
                dp[idx][transactions] = profit;
            }
        }
        return dp[0][0];
    }

    private static int memoization(int[] prices, int transactions, int idx, int[][] dp){
        if(idx == prices.length || transactions == 4) return 0;
        if(dp[idx][transactions] != -1) return dp[idx][transactions];

        int profit =0;
        if(transactions%2==0){
            profit = Math.max((-prices[idx] + memoization(prices, transactions+1, idx+1, dp)) , memoization(prices, transactions, idx+1, dp));
        }  
        else{
            profit = Math.max((prices[idx] + memoization(prices, transactions+1, idx+1, dp)) , memoization(prices, transactions, idx+1, dp));
        }
        return dp[idx][transactions] = profit;
    }

    private static int recursive(int[] prices, int transactions, int idx){
        if(idx == prices.length || transactions == 4) return 0;
        
        int profit =0;
        if(transactions%2==0){
            profit = Math.max((-prices[idx] + recursive(prices, transactions+1, idx+1)) , recursive(prices, transactions, idx+1));
        }  
        else{
            profit = Math.max((prices[idx] + recursive(prices, transactions+1, idx+1)) , recursive(prices, transactions, idx+1));
        }
        return profit;
    }
}
