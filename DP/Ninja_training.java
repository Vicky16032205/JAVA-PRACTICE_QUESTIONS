package DP;

public class Ninja_training {
    public static void main(String[] args) {
        int[][] arr = {
                        {1, 2, 5}, 
                        {3, 1, 1}, 
                        {3, 3, 3}
                    };
        int[][] dp = new int[arr.length][4];
        System.out.println(maximumPoints(arr,arr.length-1,3,dp));

        int[][] dp2 = new int[arr.length][4];
        System.out.println(maximumPointsTabu(arr,arr.length,dp2));

        int[] prev = new int[4];
        System.out.println(spaceOptimize(arr,arr.length,prev));
    }

    private static int spaceOptimize(int[][] arr, int n, int[] prev) {
        prev[0] = Math.max(arr[0][1] , arr[0][2]);
        prev[1] = Math.max(arr[0][0] , arr[0][2]);
        prev[2] = Math.max(arr[0][1] , arr[0][0]);
        prev[3] = Math.max(arr[0][0] , Math.max(arr[0][1] , arr[0][2]));

        for(int day=1;day<n;day++){
            int[] temp = new int[4];
            for(int last = 0;last<4;last++){

                for(int task = 0;task < 3;task++){
                    if(task != last){
                        int point = arr[day][task] + prev[task];
                        temp[last] = Math.max(temp[day] , point);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];
    }

    private static int maximumPointsTabu(int[][] arr, int n, int[][] dp) {
        dp[0][0] = Math.max(arr[0][1] , arr[0][2]);
        dp[0][1] = Math.max(arr[0][0] , arr[0][2]);
        dp[0][2] = Math.max(arr[0][1] , arr[0][0]);
        dp[0][3] = Math.max(arr[0][0] , Math.max(arr[0][1] , arr[0][2]));
        
        for(int day=1;day<n;day++){
            for(int last = 0;last<4;last++){
                
                dp[day][last] = 0;
                
                for(int task = 0;task < 3;task++){
                    if(task != last){
                        int point = arr[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last] , point);
                    }
                }
            }
        }
        return dp[n-1][3];
    }

    private static int maximumPoints(int[][] arr, int n, int done, int[][] dp) {
        int maxi = 0;
        if(n<0) return 0;
        if(dp[n][done] != 0) return dp[n][done];
        if(n == 0){
            for(int i=0;i<3;i++){
                if(i == done) continue;
                maxi = Math.max(maxi, arr[0][i]);
            }
            return maxi;
        }
        
        for(int i=0;i<3;i++){
            if(i == done) continue;
            int points = arr[n][i] + maximumPoints(arr, n-1, i, dp);
            maxi = Math.max(maxi, points);
        }
        return dp[n][done] = maxi;
    }

}
