public class find_intersection {

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {

// data of linked list NodeList A.
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


// data of another linked list NodeList B.
        Node a1 = new Node(8);
        Node b1 = new Node(45);
        Node c1 = new Node(67);
        Node d1 = new Node(21);
        Node e1 = new Node(9);
        Node f1 = new Node(15);
        Node g1 = new Node(52);
        Node h1 = new Node(7);
        Node i1 = new Node(23);
        Node j1 = new Node(95);

        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = e1;
        e1.next = f1;
        f1.next = g1;
        g1.next = h1;
        h1.next = i1;
        i1.next = j1;

        Node required = findIntersection_of_both(a , a1);
        System.out.println("This is the intersection point : "+required.data);
    }


    public static Node findIntersection_of_both(Node a , Node a1){
        Node tempA = a;
        Node tempB = a1;
        int sizeA = 0;
        int sizeB = 0;
        while(tempA!=null){
            sizeA++;
            tempA = tempA.next;
        }
        while(tempB!=null){
            sizeB++;
            tempB = tempB.next;
        }

        tempA = a;
        tempB = a1;

        if(sizeA > sizeB){
            for(int i=1;i<=sizeA-sizeB;i++){
                tempA = tempA.next;
            }
        }
        else{
            for(int i=1;i<=sizeB-sizeA;i++){
                tempB = tempB.next;
            }
        }

        while(tempA != null){
            if(tempA.data == tempB.data){
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }
}
