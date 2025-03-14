public class delete_middle_element {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static Node even_left_middle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node odd_middle_element_even_right_middle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(13);
        Node c = new Node(4);
        Node d = new Node(12);
        Node e = new Node(10);
        Node f = new Node(6);
        Node g = new Node(0);
        Node h = new Node(1);
        Node i = new Node(7);
        Node j = new Node(18);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = j;

        Node middle = odd_middle_element_even_right_middle(a);
        System.out.println("Middle element "+middle.data);
        Node middle_left = even_left_middle(a);
        System.out.println("Left middle element " + middle_left.data);
        display(a);
        a = delete_right_middle_element_or_odd(a);
        display(a);
    }

    public static void display(Node head){
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static Node delete_right_middle_element_or_odd(Node head){
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;
        return head;
    }
}
