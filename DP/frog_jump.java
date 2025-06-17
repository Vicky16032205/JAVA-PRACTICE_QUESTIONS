package DP;

public class frog_jump {
    public static void main(String[] args) {
        int[] height = {30, 20, 50, 10, 40};
        int result = minCost(height);
        System.out.println("Minimum cost using tabulation: " + result);

        result = minCost2(height);
        System.out.println("Minimum cost using memoization: " + result);
    }

    public static int minCost(int[] height){
        int n = height.length;
        int[] dp = new int[n];

        dp[0] = 0;
        for(int i=1;i<n;i++){
            int onejump = dp[i-1] + Math.abs(height[i] - height[i-1]);
            int twojump = Integer.MAX_VALUE;
            if(i>1) twojump = dp[i-2] + Math.abs(height[i] - height[i-2]);

            dp[i] = Math.min(onejump,twojump);
        }
        return dp[n-1];
    }

    public static int minCost2(int[] height){
        int n = height.length;
        int[] dp = new int[n+1];
        return memoize(n-1,height,dp);
    }

    private static int memoize(int n, int[] height, int[] dp) {
        if(n==0) return 0;

        int onejump = memoize(n-1, height, dp) + Math.abs(height[n] - height[n-1]);
        int twojump = Integer.MAX_VALUE;
        if(n>1) twojump = memoize(n-2, height, dp) + Math.abs(height[n] - height[n-2]);

        return dp[n] = Math.min(onejump, twojump);
    }
}
