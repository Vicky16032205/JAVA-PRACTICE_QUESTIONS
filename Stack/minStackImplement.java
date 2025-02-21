package Stack;

import java.util.Stack;

public class minStackImplement {
    public static void main(String[] args) {
        int[] arr = {7,8,6,3,9,5};
        minStack(arr);
    }

    public static void minStack(int[] arr){
        Stack<Integer> st = new Stack<>();
        Stack<Integer> res = new Stack<>();

        st.push(arr[0]);
        res.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            st.push(arr[i]);
            if(arr[i] >= res.peek()){
                res.push(res.peek());
            }
            else{
                res.push(arr[i]);
            }
        }

        while(!res.isEmpty()){
            int x = res.pop();
            System.out.print(x + " ");
        }
    }
}

// LEETCODE PROBLEM SOLUTION USING EXTRA SPACE FOR STACKS :

// class MinStack {

//     Stack<Integer> st = new Stack<>();
//     Stack<Integer> res = new Stack<>();

//     public MinStack() {
//         // constructor
//     }
    
//     public void push(int val) {
//         if(st.isEmpty()){
//             st.push(val);
//             res.push(val);
//         }
//         else{
//             st.push(val);
//             if(res.peek() < val) res.push(res.peek());
//             else res.push(val);
//         }
//     }
    
//     public void pop() {
//         st.pop();
//         res.pop();
//     }
    
//     public int top() {
//         return st.peek();
//     }
    
//     public int getMin() {
//        return res.peek();
//     }
// }