public class palindrome {

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }

    public static Node reverse_list(Node head){
        Node curr = head;
        Node agla = head;
        Node prev = null;
        
        while(curr!=null){
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
        return prev;
    }

    public static boolean isPalindrome(Node head){
        Node temp = head;
        Node copied = deepCopy(head);
        copied = reverse_list(copied);
        Node temp2 = copied;

        while(temp!=null && temp2 != null){
            if(temp.data != temp2.data){
                return false;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }
        return true;
    }

    public static Node deepCopy(Node head){
        if (head == null) return null;

        Node newHead = new Node(head.data);
        Node newTail = newHead;
        Node temp = head.next;  

        while (temp != null) {
            newTail.next = new Node(temp.data);
            newTail = newTail.next;
            temp = temp.next;

        }

        return newHead;
    }

    public static void main(String[] args) {
        Node a = new Node(81);
        Node b = new Node(97);
        Node c = new Node(78);
        Node d = new Node(97);
        Node e = new Node(80);
        Node f = new Node(99);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        System.out.println(isPalindrome(a));
    }
}
