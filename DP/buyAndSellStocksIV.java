package DP;

public class buyAndSellStocksIV {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int k = 2;

        int[][][] dp = new int[prices.length+1][2][k+1];
        System.out.println("Tabulation: "+ tabulation(prices, dp, k));

        System.out.println("Space Optimization: "+ space(prices, k));
    }

    private static int space(int[] prices, int k){
        int n = prices.length;
        int[][] after = new int[2][k+1];

        for(int idx = n-1;idx>=0;idx--){
            int[][] curr = new int[2][k+1];
            for(int buy=0;buy<=1;buy++){
                for(int transactions=1;transactions<=k;transactions++){
                    int profit = 0;
                    if(buy==1){
                        profit = Math.max(-prices[idx] + after[0][transactions] , after[1][transactions] );
                    }
                    else{
                        profit = Math.max(prices[idx] + after[1][transactions-1] , after[0][transactions]);
                    }

                    curr[buy][transactions] = profit;
                }
            }
            after = curr;
        }
        return after[1][k];
    }

    private static int tabulation(int[] prices, int[][][] dp, int k) {
        for(int idx=prices.length-1;idx>=0;idx--){
            for(int buy=0;buy<=1;buy++){
                for(int transactions= 1;transactions<=k;transactions++){
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
        return dp[0][1][k];
    }
}
