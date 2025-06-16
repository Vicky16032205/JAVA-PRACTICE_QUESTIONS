package DP;

public class fibonacci{
    public static void main(String[] args) {
        int n = 20;
        if(n<0){
            System.out.println("Enter number greater than 0");
            return;
        }
        int[] dp = new int[n+1];

        for(int i=0;i<=n;i++){
            dp[i] = -1;
        }
        System.out.println("Memoization fibonacci Sum of "+n+": "+FibCal(n,dp));    // Memoization technique. 

        for(int i=0;i<=n;i++){
            dp[i] = 0;
        }
        System.out.println("Tabulation method fibonacci Sum of "+n+": "+FibCalOpt(n,dp));    // Tabulation method

        System.out.println(" Optimized fibonacci Sum of "+n+": "+Ord_one(n));     // Most optimized solution saving whole space complexity.
    }

    public static int FibCal(int n, int[] dp){
        // Recursion method or Memoization taking:
            // Time complexity: O(N)
            // Space complexity: O(N)+O(N) ; first one for array declaration and another for recursion stack.
        if(n<=1) return n;

        if(dp[n] != -1) return dp[n];

        dp[n] = FibCal(n-1, dp)+FibCal(n-2, dp);
        return dp[n];
    }

    public static int FibCalOpt(int n, int[] dp){
        // Tabulation method where bottom-up technique is followed.
            // Time complexity: O(N)
            // Space complexity: O(N) ; this is taking only array initialization space.
        if(n == 0) return 0;
        
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }

    public static int Ord_one(int n){
        // this is simple technique or say most optimized one where:
            // Time complexity: O(N)
            // Space complexity: O(1)
        if(n==0) return 0;
        int prev = 1;
        int prev2 = 0;

        for(int i=2;i<=n;i++){
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}