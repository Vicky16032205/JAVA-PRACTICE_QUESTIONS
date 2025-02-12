package Stack;

public class stack_implement_using_linked_list {

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static class Stack{
        Node head = null;
        int idx = 0;


        void push(int x){
            Node temp = new Node(x);
            temp.next = head;
            head = temp;
            idx++;
        }

        void display(){
            displayRec(head);
            System.out.println();
        }

        void displayRec(Node h){
            if(h == null){
                return; 
            }
            displayRec(h.next);
            System.out.print(h.data+" ");
        }

        int pop(){
            int c = head.data;
            head = head.next;
            idx--;
            return c;
        }

        int peek(){
            return head.data;
        }

        int size(){
            return idx;
        }

        boolean isEmpty(){
            if(head == null) return true;
            return false;
        }
    }


    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(4);
        st.push(5);
        st.push(7);
        st.push(3);
        st.push(9);
        st.push(6);
        st.display();

        System.out.println(st.peek());;
        System.out.println(st.pop());;

        st.display();

        System.out.println(st.size());

        System.out.println(st.isEmpty());;
    }
}
