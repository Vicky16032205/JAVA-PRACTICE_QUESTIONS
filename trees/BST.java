package trees;
import java.util.*;
public class BST {

    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }
    }

    public static void display(Node root){
        if(root ==  null){
            return;
        }
        display(root.left);
        System.out.println(root.val);
        display(root.right);
    }

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
        sc.close();
    }

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
                root.right = new Node(x);;
            }
            else{
                makeTree(root.right, x);
            }
        }
    }
}
