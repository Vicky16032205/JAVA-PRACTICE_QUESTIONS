package DP;

public class subsetSumEqualsTarget {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1};
        int target = 4;
        System.out.println("Recursive solution: " +targetPresent(arr,arr.length-1,target));

        boolean[] dp = new boolean[arr.length];
        System.out.println("Memoization solution: " +target(arr,arr.length-1,target,dp));
    }

    private static boolean target(int[] arr, int n, int target, boolean[] dp) {
        if(n==0){
            return arr[0] == target;
        }
        if(target == 0) return true;

        if(dp[n] != false) return true;

        boolean not_take = targetPresent(arr, n-1, target);
        boolean take = false;
        if(arr[n] <= target){
            take = targetPresent(arr, n-1, target-arr[n]);
        }
        return dp[n] = not_take || take;
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
