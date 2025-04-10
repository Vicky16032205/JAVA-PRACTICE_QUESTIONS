package trees;

import java.util.*;

public class isValidBST {
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
        isValidBST level = new isValidBST(sc);
        System.out.print("in-order traversal : ");
        level.display();
        System.out.print("\nWill check if the tree is balanced by values or not : "); 
        level.balanced();
    }


    // function for writing the logic of constructing a tree.
    public isValidBST(Scanner sc){
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

    public void balanced(){
        boolean answer = balanced(this.root,null,null);
        if(answer){
            System.out.println("Tree is balanced by values.");
        }
        else{
            System.out.println("Not balanced");
        }
    }
    private boolean balanced(Node root,Integer left, Integer right){
        if(root == null) return true;
         
        if(left != null && root.val<=left){
            return false;
        }
        if(right != null && root.val>=right){
            return false;
        }

        boolean leftSide = balanced(root.left, left, root.val);
        boolean rightSide = balanced(root.right, root.val, right);

        return leftSide && rightSide;
    }
}
