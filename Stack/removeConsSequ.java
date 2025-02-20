package Stack;

import java.util.Stack;

public class removeConsSequ {

    public static void consecutiveSequence(int[] arr){
        Stack<Integer> st = new Stack<>();

        st.push(arr[0]);
        for(int i=0;i<arr.length;i++){
            if(arr[i] == st.peek()){
                continue;
            }
            else{
                st.push(arr[i]);
            }
        }
        int[] res = new int[st.size()];

        for(int i=res.length-1 ; i>=0 ;i--){
            res[i] = st.pop();
        }

        for(int i=0;i<res.length;i++){
            System.out.print(res[i] + " ");
        }
    } 

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,4,5,6,6,6,9,4,5,6,7,8,9};
        consecutiveSequence(arr);
    }
}
