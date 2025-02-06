public class Recursive_rev {

     public static Node recursive_reverse(Node head){
        if(head.next == null) return head;
        Node newHead = recursive_reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        Node a1 = new Node(8);
        Node b1 = new Node(45);
        Node c1 = new Node(67);
        Node d1 = new Node(21);
        Node e1 = new Node(9);
        Node f1 = new Node(87);
        Node g1 = new Node(52);
        Node h1 = new Node(7);
        Node i1 = new Node(23);
        Node j1 = new Node(95);

        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = e1;
        e1.next = f1;
        f1.next = g1;
        g1.next = h1;
        h1.next = i1;
        i1.next = j1;

        a1 = recursive_reverse(a1);
        display(a1);
    }
}
