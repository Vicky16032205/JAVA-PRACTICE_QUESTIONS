package Stack;

import java.util.Stack;

public class StockSpanProblem {

    public static void span(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        res[0] = 1;
        st.push(0);
        for(int i=1;i<arr.length;i++){

            if(arr[i] < arr[st.peek()]){
                res[i] = i-st.peek();
                st.push(i);
            }

            else{
                while((!st.isEmpty()) && (arr[i] >= arr[st.peek()])){
                    st.pop();
                }

                if(!st.isEmpty()){
                    res[i] = i-st.peek();
                }
                else{
                    res[i] = i+1;
                }

                st.push(i);
            }
        }

        for(int i=0;i<res.length;i++){
            System.out.print(res[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,4,5,90,120,80};
        span(arr);
    }
}
