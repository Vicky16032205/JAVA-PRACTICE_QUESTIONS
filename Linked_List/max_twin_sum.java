public class max_twin_sum {
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

    public static int isPalindrome(Node head){
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

        int maximum = 0;
        int sum = 0;

        while (temp!=slow) {
            sum = temp.data + temp2.data;
            maximum = Math.max(maximum, sum);
            temp=temp.next;
            temp2 = temp2.next;
        }
        return maximum;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(9);
        Node f = new Node(4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        int ans = isPalindrome(a);
        System.out.println("maximum twin sum is : "+ ans);
    }
}
