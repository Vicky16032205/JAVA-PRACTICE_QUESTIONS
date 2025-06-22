package DP;

public class subsetSumEqualsTarget {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1};
        int target = 4;
        System.out.println(targetPresent(arr,arr.length-1,target));
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
