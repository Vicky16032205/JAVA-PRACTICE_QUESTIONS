package DP;

class buyAndSellStocksIII {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        int transactions = 2;

        System.out.println("Buy and Sell stocks II problem of leetcode ways to solve the problem ==>");
        System.out.println("Using recursion: "+profitMade(0,1,prices,transactions));
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
