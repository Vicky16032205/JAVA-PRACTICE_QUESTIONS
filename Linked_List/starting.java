public class starting {

    // printing in reverse order
    public static void printRev(Node head){
        if(head == null) return;
        printRev(head.next);
        System.out.print(head.data+" ");
    }

    // printing recursively linked list
    public static void printRecursively(Node head){ 
        if(head == null) {
            System.out.println();
            return;
        } 
        System.out.print(head.data + " ");
        printRecursively(head.next);
    }

    // printing linked list iteratively.
    public static void printLinked_List(Node head){
        int count = 0;
        Node temp = head;
        while(temp!= null){
            System.out.print(temp.data + " ");
            temp = temp.next;
            count++;
        }
        System.out.println();
        System.out.println("total elements present are : "+ count);
        System.out.println();
    }

    public static class Node{

        // initializing linked list nodes with data and address of the next linked list node.
        int data;
        Node next;

        // calling constructor.
        Node(int data){
            this.data = data;
        }
    }


    public static void main(String[] args) {
        // making methods for using linked list .

        Node a = new Node(5);
        Node b = new Node(3);
        Node c = new Node(9);
        Node d = new Node(8);
        Node e = new Node(13);

        // joining nodes address of the next one node with the previous one.
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        System.out.println("calling iteratively");
        printLinked_List(a);
        System.out.println("calling recursively");
        printRecursively(a);
        System.out.println("Printing in reverse order .");
        printRev(a);
    }
}

//  the starting node is called the head of the linked list .
// the ending node is called the tail of the linked list .

// we use the concept of creating the new node temp which is denoting the same head of the linked list because
// if we do not do this then the linked list once printed cannot be printed again 
// if we use original names for them which are given at starting. 
