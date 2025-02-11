package Stack;

import java.util.Stack;

public class copy_elements {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(45);
        st.push(4);
        st.push(5);
        st.push(87);
        st.push(45);
        st.push(65);

        System.out.println("printing of original stack elements : "+ st);
        Stack<Integer> revCopyStack = new Stack<>();
        while(!st.isEmpty()){
            revCopyStack.add(st.pop());
        }
        System.out.println("printing of stack elements in reverse order : "+ revCopyStack);

        Stack<Integer> sameOrderCopy = new Stack<>();
        while(!revCopyStack.isEmpty()){
            sameOrderCopy.add(revCopyStack.pop());
        }
        System.out.println("printing of stack elements in original order but copied : "+ sameOrderCopy);
    }
}
