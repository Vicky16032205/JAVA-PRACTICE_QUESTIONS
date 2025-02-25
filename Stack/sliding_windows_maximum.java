package Stack;

public class sliding_windows_maximum {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        sliding_window_brute(arr , k); // brute force approach
    }

    public static void sliding_window_brute(int[] arr , int k){
        int n = arr.length;
        int[] res = new int[n-k+1];
        int z = 0;
        for(int i=0;i<n-k+1;i++){
            int max = Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                max = Math.max(max , arr[j]);
            }
            res[z++] = max;
        }

        for(int i=0;i<res.length;i++){
            System.out.print(res[i] + " ");
        }
    }
}
