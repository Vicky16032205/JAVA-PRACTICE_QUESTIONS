package trees;
import java.util.*;
public class BST {

    // for node initialization.
    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }
    }

    // for displaying the tree values.
    public static void display(Node root){
        if(root ==  null){
            return;
        }
        display(root.left);
        System.out.println(root.val);
        display(root.right);
        
    }

    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter root value: ");
        int y = sc.nextInt();
        Node root = new Node(y);

        while(true){
            System.out.print("enter value or if wanted to end printing write -1 :  ");
            int x = sc.nextInt();
            if(x==-1){
                break;
            }
            makeTree(root , x);
        }
        System.out.println("In order traversal : ");
        display(root);
        if(isBalanced(root)){
            System.out.println("Tree is balanced.");
        }
        else{
            System.out.println("Tree is not balanced.");
        }
        sc.close();
    }

    // tree making will be done here.
    public static void makeTree(Node root, int x){
        if(x<root.val){
            if(root.left == null){
                root.left = new Node(x);
            }
            else{
                makeTree(root.left, x);
            } 
        }
        else{
            if(root.right == null){
                root.right = new Node(x);
            }
            else{
                makeTree(root.right, x);
            }
        }
    }

    // tree height verification will be done here.
    public static boolean isBalanced(Node root){
        return height(root) != -1;
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lf = height(root.left);
        if(lf == -1) return -1;
        int rt = height(root.right);
        if(rt == -1) return -1;

        if(Math.abs(lf-rt)>1){
            return -1;
        }
        return Math.max(lf , rt)+1;
    }
}
