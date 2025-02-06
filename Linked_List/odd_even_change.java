public class odd_even_change {

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

    public static Node rearrange(Node head){

        if(head == null || head.next == null) return head;


        Node temp = head;
        Node odd = new Node(0);
        Node even = new Node(0);
        Node tempOdd = odd;
        Node tempEven = even;
        int count =1;

        while(temp!=null){
            if(count%2 == 0){
                tempEven.next = temp;
                tempEven = tempEven.next;
            }
            else{
                tempOdd.next = temp;
                tempOdd = tempOdd.next;
            }
            temp = temp.next;
            count++;
        }

        if(count%2 ==0){
            tempEven.next = null;
            tempOdd.next = even.next;
        }
        else tempOdd.next = even.next ;

        return odd.next;
    }

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(15);
        Node c = new Node(52);
        Node d = new Node(75);
        Node e = new Node(59);
        Node f = new Node(35);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        display(a);
        Node changedNode = rearrange(a);
        display(changedNode);
    }
}