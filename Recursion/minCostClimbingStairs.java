package Recursion;
public class minCostClimbingStairs {

    public static int minCost(int[] cost) {
        int n = cost.length;
        int prev2 = cost[0];
        int prev1 = cost[1];
        for (int i = 2; i < n; i++) {
            int current = Math.min(prev1, prev2) + cost[i];
            prev2 = prev1;
            prev1 = current;
        }
        return Math.min(prev1, prev2);
    }
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        System.out.println(minCost(cost));
    }
}