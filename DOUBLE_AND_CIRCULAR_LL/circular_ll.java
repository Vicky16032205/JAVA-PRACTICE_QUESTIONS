package DOUBLE_AND_CIRCULAR_LL;

public class circular_ll {

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
        Node res = insertAtHead(a , 50);
        display(res);
        res = insertAtEnd(res , 90);
        display(res);
        res = insertAtAnyPoint(res, 45, 2);
        display(res);
    }

    public static Node insertAtHead(Node head , int x){
        Node val = new Node(x);

        if(head == null){
            val.next = val;
            return val;
        }
        Node temp = head;
        
        while(temp.next != head){
            temp = temp.next;
        }
        temp.next = val;
        val.next = head;
        return val;
    }

    public static Node insertAtEnd(Node head , int x){
        Node val = new Node(x);

        if(head == null){
            val.next = val;
            return val;
        }

        Node temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        temp.next = val;
        val.next = head;
        return head;
    }

    public static Node insertAtAnyPoint(Node head , int x , int index){
        Node val = new Node(x);
        if(head == null){
            val.next = val ;
            return val;
        }

        Node temp = head;
        Node nextNode = head.next;
        for(int i=0;i<index;i++){
            temp = temp.next;
            nextNode = nextNode.next;
        }

        temp.next = val;
        val.next = nextNode;
        return head;
    }
}
