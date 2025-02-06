public class optimized_palindrome {

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }

    public static Node reverse(Node head){
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
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        Node rev = reverse(slow);
        Node temp2 = rev;
        slow.next = rev;

        while(temp!=slow){
            if(temp.data != temp2.data){
                return false;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node a = new Node(81);
        Node b = new Node(97);
        Node c = new Node(78);
        Node d = new Node(78);
        Node e = new Node(97);
        Node f = new Node(81);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        System.out.println(isPalindrome(a));
    }
}
