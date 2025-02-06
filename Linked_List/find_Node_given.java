public class find_Node_given {

    public static void main(String[] args) {
        Node a = new Node(8);
        Node b = new Node(9);
        Node c = new Node(7);
        Node d = new Node(4);
        Node e = new Node(2);
        Node f = new Node(99);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        Node ans = finding_given_node_from_last(2 , a);
        System.out.println("Brute force approach");
        System.out.println(ans.data);


        Node res = FastAndSlowapproach(2, a);
        System.out.println("Optimized approach");
        System.out.println(res.data);
    }

    public static class Node {
        int data;
        Node next ;
        Node(int data){
            this.data = data;
        }
    }


    // Brute force approach

    public static Node finding_given_node_from_last(int n , Node a){

        Node temp = a;
        int size = 0;
        while (temp!=null) {
            temp= temp.next;
            size++;
        }

        temp = a;
        if(size-n < 0) {
            System.out.println("Enter right input only . It exceeds the size of original node .");
            return null;
        }
        for(int i=1;i<=size-n;i++){
            temp = temp.next;
        }
        return temp;
        
    }



    // expected or optimized approach


    public static Node FastAndSlowapproach(int n, Node a){
        Node fast = a;
        Node slow = a;

        for(int i=0;i<n;i++){
            fast = fast.next;
        }

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}