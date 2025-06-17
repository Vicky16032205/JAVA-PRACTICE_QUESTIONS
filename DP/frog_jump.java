package DP;

public class frog_jump {
    public static void main(String[] args) {
        int[] height = {10, 30, 40, 20};
        int result = minCost(height);
        System.out.println("Minimum cost: " + result);
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
}
