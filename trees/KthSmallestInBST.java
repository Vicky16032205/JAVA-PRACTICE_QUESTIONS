package trees;

import java.util.*;

public class KthSmallestInBST {
    // creating Node class here.
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    } 

    Node root;

    // main function.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KthSmallestInBST level = new KthSmallestInBST(sc);
        System.out.print("in-order traversal : ");
        level.display();
        System.out.print("\nEnter Element index : ");
        level.kth(sc);
        sc.close();
    }


    // function for writing the logic of constructing a tree.
    public KthSmallestInBST(Scanner sc){
        System.out.print("Enter root value : ");
        this.root = new Node(sc.nextInt());
        System.out.println("enter left child of "+root.val+ " or write -1 to stop : ");
        root.left = constructTree(null,sc);
        System.out.println("enter right child of "+root.val+ " or write -1 to stop : ");
        root.right = constructTree(null, sc);

    }

    // display function for printing the tree.
    public void display(){
        display(this.root);
    }
    private void display(Node root){
        if(root == null) return;

        display(root.left);
        System.out.print(root.val+" ");
        display(root.right);
    }

    // for constructing the tree.
    public Node constructTree(Node root , Scanner sc){
        int x = sc.nextInt();
        if(x==-1) return null;

        Node node = new Node(x);

        System.out.println("enter left child of "+x+" : ");
        node.left = constructTree(node.left, sc);

        System.out.println("enter right child of "+x+" : ");
        node.right = constructTree(node.right, sc);

        return node;
    }

    public void kth(Scanner sc){
        int x = sc.nextInt();
        List<Integer> result = new ArrayList<>();
        kth(this.root,result);
        if(x<1 || x>result.size()){
            System.out.println("Invalid index please try again with correct index.");
            return;
        }
        System.out.println("Kth Smallest element is "+result.get(x-1));
    }
    private void kth(Node root ,List<Integer> result){
        if(root == null) return;
        kth(root.left,result);
        result.add(root.val);
        kth(root.right,result);
    }
}
