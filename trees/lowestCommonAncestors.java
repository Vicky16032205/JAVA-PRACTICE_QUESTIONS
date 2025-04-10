package trees;

import java.util.Scanner;

public class lowestCommonAncestors {
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
        lowestCommonAncestors level = new lowestCommonAncestors(sc);
        System.out.print("in-order traversal : ");
        level.display();
        System.out.print("\nLowest Common Ancestor is : ");
        level.lca();
    }


    // function for writing the logic of constructing a tree.
    public lowestCommonAncestors(Scanner sc){
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

    public void lca(){
        Node x = lca(this.root , 50 , 70);
        if(x== null){
            System.out.println("Nodes not found");
        }
        else
            System.out.println(x.val);
    }
    private Node lca(Node root , int a, int b){
        if(root==null || root.val == a || root.val == b){
            return root;
        }

        Node x = lca(root.left, a, b);
        Node y = lca(root.right, a, b);

        if(x==null && y==null){
            return null;
        }
        if(x != null && y != null){
            return root;
        }
       return (x!=null)?x:y;

    }
}
