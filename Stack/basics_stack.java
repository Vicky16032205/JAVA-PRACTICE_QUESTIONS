package Stack;

import java.util.Stack;

public class basics_stack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(45);
        st.push(4);
        st.push(5);
        st.push(87);
        st.push(45);
        st.push(65);
        System.out.println("printing elements : ");
        System.out.println(st);
        System.out.println("Getting top element : "+st.peek());
        System.out.println("Deletion of top element : "+st.pop());
        System.out.println("printing elements : ");
        System.out.println(st);
    }
}
