package Stack;

import java.util.Stack;

public class remove_bottom_or_index {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(45);
        st.push(4);
        st.push(5);
        st.push(87);
        st.push(25);
        st.push(65);
        System.out.println(st);
        remove_bottom(st);
        remove_at_index(st , 5);
    }
    public static void remove_bottom(Stack<Integer> st){
        Stack<Integer> rt = new Stack<>();
        int i=1;
        int n = st.size();
        while( i <= n-1){
            rt.push(st.pop());
            i++;
        }
        st.pop();

        while(!rt.isEmpty()){
            st.push(rt.pop());
        }

        System.out.println(st);
    }

    public static void remove_at_index(Stack<Integer> st , int index){
        Stack<Integer> rai = new Stack<>();
        int n = st.size();
        int i=1;

        while(i <= n-index){
            rai.push(st.pop());
            i++;
        }

        st.pop();

        while(!rai.isEmpty()){
            st.push(rai.pop());
        }

        System.out.println(st);
    }
}
