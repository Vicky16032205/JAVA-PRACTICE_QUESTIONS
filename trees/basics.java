package trees;

public class basics {

    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    public static void display(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        display(root.left);
        display(root.right);
    }

    public static void displayChild(Node root){
        if(root==null || (root.left == null && root.right == null)){
            return;
        }
        System.out.print(root.data+" -> ");
        if(root.left!=null) System.out.print(root.left.data+" , ");
        else System.out.print("null , ");
        if(root.right!=null) System.out.println(root.right.data+" ");
        else System.out.print("null");

        displayChild(root.left);
        displayChild(root.right);
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
        // Node f = new Node(7);
        b.left = e;

        display(root);
        System.out.println();
        displayChild(root);
    }
}