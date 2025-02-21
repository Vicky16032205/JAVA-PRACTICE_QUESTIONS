package Stack;

import java.util.*;

public class nextGreater2ndApproach {

    public static void greaterElement(int[] arr){

        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        Arrays.fill(res , -1);
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }
        for(int i=0;i<res.length;i++){
            System.out.print(res[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,3,2,1,6,3,4};
        greaterElement(arr);
    }
}
