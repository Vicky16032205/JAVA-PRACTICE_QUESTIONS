package trees;

public class minimum_and_Product {

    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        root.left = a;
        root.right = b;

        Node c = new Node(4);
        Node d = new Node(5);
        a.left = c;
        a.right = d;

        Node e = new Node(6);
        b.right = e;

        Node f = new Node(7);
        e.left = f;

        System.out.println("Minimum element in tree is : "+ minimum(root));
        System.out.println("Total product of elements in tree is : "+ product(root));
    }

    public static int minimum(Node root){
        if(root == null) return Integer.MAX_VALUE;
        return Math.min(root.data , Math.min(minimum(root.left) , minimum(root.right)));
    }

    public static int product(Node root){
        if(root == null) return 1;
        return root.data * product(root.left) * product(root.right);
    }
}
