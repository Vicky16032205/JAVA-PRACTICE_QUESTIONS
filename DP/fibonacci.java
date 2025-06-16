package DP;

public class fibonacci{
    public static void main(String[] args) {
        int n = 6;
        if(n<0){
            System.out.println("Enter number greater than 0");
            return;
        }
        int[] dp = new int[n+1];

        for(int i=0;i<=n;i++){
            dp[i] = -1;
        }
        System.out.println("Fibonacci Sum of "+n+": "+FibCal(n,dp));

        for(int i=0;i<=n;i++){
            dp[i] = 0;
        }

        System.out.println("Fibonacci Sum of "+n+": "+FibCalOpt(n,dp));
        // System.out.println("Fibonacci Sum of "+n+": "+Ord_one(n,dp));
    }

    public static int FibCal(int n, int[] dp){
        // Recursion method or Memoization taking:
            // Time complexity: O(N)
            // Space complexity: O(N)+O(N) ; first one for array declaration and another for recursion stack.
        if(n<=1) return n;

        if(dp[n] != -1) return dp[n];

        return FibCal(n-1, dp)+FibCal(n-2, dp);
    }

    public static int FibCalOpt(int n, int[] dp){
        // Tabulation method where bottom-up technique is followed.
            // Time complexity: O(N)
            // Space complexity: O(N) ; this is taking only array initialization space.
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
}