package DP;

public class fibonacci{
    public static void main(String[] args) {
        int n = 6;
        if(n<0){
            System.out.println("Enter number greater than 0");
            return;
        }
        int[] dp = new int[n];

        for(int i=0;i<n;i++){
            dp[i] = -1;
        }
        System.out.println("Fibonacci Sum of "+n+": "+FibCal(n,dp));
    }

    public static int FibCal(int n, int[] dp){
        if(n<=1) return n;

        if(dp[n-1] != -1) return dp[n-1];

        return FibCal(n-1, dp)+FibCal(n-2, dp);
    }
}