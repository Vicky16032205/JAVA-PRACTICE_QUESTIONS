package DP;

public class circular_MaxNonAdjSum {
    public static void main(String[] args) {
        int[] arr = {316, 30875, 28056, 29256, 6771, 7084, 5506, 12147, 2937};
        if(arr.length<1){
            System.out.println(arr[0]);
            return;
        }
        int[] arr1 = new int[arr.length-1];
        int[] arr2 = new int[arr.length-1];

        for(int i=1;i<arr.length;i++){
            arr1[i-1] = arr[i];
        }
        for(int i=0;i<arr.length-1;i++){
            arr2[i] = arr[i];
        }
        System.out.println("Space Optimized answer: " + Math.max(spaceOptimize(arr1,arr1.length-1),spaceOptimize(arr2,arr2.length-1)));
    }

    public static int spaceOptimize(int[] arr, int n){
        int prev = arr[0];
        int prev2 = 0;

        for(int i=1;i<=n;i++){
            int pick = arr[i];
            if(i>1) pick += prev2;
            int not_pick = 0 + prev;

            int curr = Math.max(pick, not_pick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
