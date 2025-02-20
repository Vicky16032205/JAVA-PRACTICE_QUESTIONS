package Stack;

import java.util.Stack;

public class nextGreaterElement {

    public static void greaterElement(int[] arr){
        int[] res = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        st.push(arr[arr.length-1]);
        res[res.length-1] = -1;

        for(int i=arr.length-2;i>=0;i--){
            res[i] = -1;

            if(arr[i] > st.peek()){
                while(st.size() > 0 && arr[i] > st.peek()){
                    st.pop();
                }
                if(!st.isEmpty()){
                    res[i] = st.peek();
                }
            }

            else if(arr[i] < st.peek()){
                res[i] = st.peek();
            }

            else{
                res[i] = -1;
            }

            st.push(arr[i]);
        }


        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,3,2,1,6,6,6,6,3,4};
        greaterElement(arr);
    }
}
