package Stack;

import java.util.Stack;

public class display_reverse_recursively {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(45);
        st.push(4);
        st.push(5);
        st.push(87);
        st.push(25);
        st.push(65);
        System.out.println(st);
        recursive_display(st);
        System.out.println();
        reverse_display(st);
        System.out.println();
        System.out.println(st);
    }

    public static void recursive_display(Stack<Integer> st){
        if(st.isEmpty()) return ;
        int top = st.pop();
        recursive_display(st);
        System.out.print(top+" ");
        st.push(top);
    }

    public static void reverse_display(Stack<Integer> st){
        if(st.isEmpty()) return ;
        int top = st.pop();
        System.out.print(top+" ");
        reverse_display(st);
        st.push(top);
    }
}
