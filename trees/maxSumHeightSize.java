package trees;

public class maxSumHeightSize {

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
        e.right = f;

        System.out.println("Number of nodes in tree is : "+ size(root));
        System.out.println("Maximum element in tree is : "+ maxTree(root));
        System.out.println("Sum of elements present in tree is : "+sum(root));
        System.out.println("Height of the tree is : " + height(root));
    }

    public static int size(Node root){
        if(root == null) return 0;
        return 1+size(root.left)+size(root.right);
    }

    public static int maxTree(Node root){
        if(root == null) return Integer.MIN_VALUE;
        return Math.max(root.data , Math.max(maxTree(root.left) , maxTree(root.right)));
    }

    public static int sum(Node root){
        if(root == null) return 0;
        return root.data + sum(root.left) + sum(root.right);
    }

    public static int height(Node root){
        if(root == null || (root.left == null && root.right == null)) return 0;
        return 1 + Math.max(height(root.left) , height(root.right));
    }
}