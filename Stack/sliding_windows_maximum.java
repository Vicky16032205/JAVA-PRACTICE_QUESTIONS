package Stack;

import java.util.Stack;

public class sliding_windows_maximum {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 1;
        sliding_window_brute(arr , k); // brute force approach

        sliding_window_slight_good(arr , k); // good approach then brute force 

        maxSlidingWindow(arr , k);
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

    public static void sliding_window_slight_good(int[] arr , int k){
        // in this approach we will be using the next greater element approach and then make the resultant array.
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        st.push(n-1);
        res[n-1] = n;
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && arr[i] > arr[st.peek()]) st.pop();
            if(st.isEmpty()) res[i] = n;
            else res[i] = st.peek();
            st.push(i);
        }
        int[] ans = new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
            int j = i;
            int max = arr[j];
            while(j<i+k){
                max = arr[j];
                j = res[j];
            }
            ans[i] = max;
        }
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i] + " ");
        }
    }


    public static void maxSlidingWindow(int[] arr , int k){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        st.push(n-1);
        res[n-1] = n;
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && arr[i] > arr[st.peek()]) st.pop();
            if(st.isEmpty()) res[i] = n;
            else res[i] = st.peek();
            st.push(i);
        }
        int[] ans = new int[n-k+1];
        int j = 0;
        int z=0;
        for(int i=0;i<n-k+1;i++){
            if(j>=i+k) j= i;
            int max = arr[j];
            while(j<i+k){
                max = arr[j];
                j = res[j];
            }
            ans[z++] = max;
        }
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i] + " ");
        }
    }
}