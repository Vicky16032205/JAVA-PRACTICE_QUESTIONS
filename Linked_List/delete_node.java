public class delete_node {

    public static void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static Node deleteNthNode(Node a , int n){
        Node fast = a;
        Node slow = a;

        for(int i=1;i<=n;i++){
            fast = fast.next;
        }
        // edge case handling if n=length of the linked list.

        if(fast == null){
            slow = slow.next;
            return slow;
        }

        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return a;
    }

    public static void main(String[] args) {
        Node a = new Node(81);
        Node b = new Node(97);
        Node c = new Node(78);
        Node d = new Node(40);
        Node e = new Node(23);
        Node f = new Node(99);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        display(a);
        a = deleteNthNode(a , 2);
        display(a);
    }
}
