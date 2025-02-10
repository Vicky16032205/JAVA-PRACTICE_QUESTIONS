package DOUBLE_AND_CIRCULAR_LL;

public class circular_ll_deletion {

    public static void display(Node head){
        Node temp = head;
        Node newTemp = temp.next;
        System.out.print(temp.data + " ");
        while(newTemp != temp){
            System.out.print(newTemp.data + " ");
            newTemp = newTemp.next;
        }
        System.out.println();
    }

    public static class Node{
        int data;
        Node next;
        // Node prev;
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

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = a;

        display(a);
        Node res = deletionAtHead(a );
        display(res);
        // res = deletionAtEnd(res);
        // display(res);
        res = deletionAtAnyPoint(res, 2);
        display(res);
    }

    public static Node deletionAtHead(Node head){
        if(head == null) return null;
        Node temp = head.next;
        while(temp.next != head){
            temp = temp.next;
        }
        temp.next = head.next;
        head = head.next;
        return head;
    }

    public static Node deletionAtEnd(Node head){
        if(head == null || head.next == head) return null;
        Node temp = head;
        while(temp.next.next!=head){
            temp = temp.next;
        }
        temp.next = head;
        return head;
    }

    public static Node deletionAtAnyPoint(Node head , int index){
        if(head == null || head.next == head) return null;
        int totalRotations = index % sizeOfLL(head); 
        Node temp = head;
        int size = 1;
        while(size < totalRotations){
            size++;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    public static int sizeOfLL(Node head){
        Node temp = head;
        int size = 1;
        while(temp.next != head){
            size++;
            temp = temp.next;
        }
        return size;
    }
}
