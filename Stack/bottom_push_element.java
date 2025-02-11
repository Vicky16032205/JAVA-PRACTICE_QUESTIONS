package Stack;

import java.util.Stack;

public class bottom_push_element {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(45);
        st.push(4);
        st.push(5);
        st.push(87);
        st.push(25);
        st.push(65);

        System.out.println("printing of original stack elements : "+ st);
        Stack<Integer> newSt = new Stack<>();
        while(!st.isEmpty()){
            newSt.push(st.pop());
        }
        newSt.push(78);

        while(!newSt.isEmpty()){
            st.push(newSt.pop());
        }
        System.out.println("Added elements at base or say bottom : "+ st);

        deleteElementAtAnyIndex(st , 32 , 2);

    }

    public static void deleteElementAtAnyIndex(Stack<Integer> st , int x , int index){
        Stack<Integer> newSt = new Stack<>();
        int i=1;
        int n = st.size();
        while(i <= n-index+1){
            newSt.push(st.pop());
            i++;
        }
        st.push(x);
        while(!newSt.isEmpty()){
            st.push(newSt.pop());
        }
        System.out.println("Element added at given index "+index +": "+st);
    }
}
