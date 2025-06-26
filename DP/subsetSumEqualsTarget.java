package DP;

public class subsetSumEqualsTarget {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1};
        int target = 4;
        System.out.println("Recursive solution: " +targetPresent(arr,arr.length-1,target));

        Boolean[][] dp = new Boolean[arr.length][target+1];
        System.out.println("Memoization solution: " +target(arr,arr.length-1,target,dp));

        boolean[][] dp2 = new boolean[arr.length][target+1];
        System.out.println("Tabulation solution: " +Present(arr,arr.length,target,dp2));
    }

    private static boolean Present(int[] arr, int n, int target, boolean[][] dp) {
        for(int i=0;i<n;i++) dp[i][0] = true;
        
        dp[0][arr[0]] = true;

        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                boolean not_take = dp[i-1][j];
                boolean take = false;

                if(j >= arr[i]){
                    take = dp[i-1][j-arr[i]];
                }
                dp[i][j] = take || not_take;
            }
        }
        return dp[n-1][target];
    }

    private static boolean target(int[] arr, int n, int target, Boolean[][] dp) {
        if(target == 0) return true;
        if(n==0) return arr[0] == target;

        if(dp[n][target] != null) return dp[n][target];

        boolean not_take = target(arr, n-1, target,dp);
        boolean take = false;
        if(arr[n] <= target){
            take = target(arr, n-1, target-arr[n],dp);
        }
        return dp[n][target] = not_take || take;
    }

    private static boolean targetPresent(int[] arr, int n, int target) {
        if(n==0){
            return arr[0] == target;
        }
        if(target == 0) return true;

        boolean not_take = targetPresent(arr, n-1, target);
        boolean take = false;
        if(arr[n] <= target){
            take = targetPresent(arr, n-1, target-arr[n]);
        }
        return not_take || take;
    }
}
