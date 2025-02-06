package DOUBLE_AND_CIRCULAR_LL;

public class basic_doubly_ll {
    static void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static void displayRev(Node tail){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        
        Node a = new Node(4);
        Node b = new Node(10);
        Node c = new Node(2);
        Node d = new Node(99);
        Node e = new Node(13);

        // front linking of elements :
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        // back chaining of elements :
        b.prev = a;
        c.prev = b;
        d.prev = c;
        e.prev = d;

        // printing in form of left to right nodes
        display(a);

        // displaying elements from right to left nodes.
        displayRev(e);
    }
}
