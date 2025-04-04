package trees;
import java.util.*;
public class AVLtree {

    
// for creating the Node class.

    public static class Node{
        int val;
        int height;
        Node left ;
        Node right;

        Node(int val){
            this.val = val;
            this.height = 1;
        }
    }
    public static Node root = null;



// function for displaying the tree.

    public static void display(Node root){
        if(root == null) return;
        System.out.print(root.val + " ");
        display(root.left);
        
        display(root.right);
    }



// function for calculating height.

    public static int ht(Node root){
        return (root == null)?0:root.height;
    }



// main body .

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<20;i++){
            root = makeTree(root , i);
        }
        sc.close();
        display(root);
        System.out.println();
        System.out.println("Level order traversal: ");
        levelOrderTraversal(root);
        System.out.println();
        System.out.println("Height of AVL Tree: " + root.height);
    }



// function for making tree.

    public static Node makeTree(Node root , int n){
        if(root == null){
            return new Node(n);
        }
        if(root.val > n){
            root.left = makeTree(root.left, n);
        }
        else{
            root.right = makeTree(root.right, n);
        }
        root.height = 1+Math.max(ht(root.left), ht(root.right));
        return AVL(root);
    }
    



// function for making the tree self structuring.

    public static Node AVL(Node root){
        int bf = ht(root.left) - ht(root.right);

        // left heavy
        if(bf>1){
            if(ht(root.left) >= ht(root.right)){
                return rightRotate(root);
            }
            else{
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }

        // right heavy
        if(bf<-1){
            if(ht(root.right) >= ht(root.left)){
                return leftRotate(root);
            }
            else{
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }
        return root;
    }

    public static Node rightRotate(Node root){
        Node p = root;
        Node c = p.left;
        p.left = c.right;
        c.right = p;

        p.height = 1 + Math.max(ht(p.left),ht(p.right));
        c.height = 1 + Math.max(ht(c.left),ht(c.right));

        return c; 
    }

    public static Node leftRotate(Node root){
        Node p =root ;
        Node c = p.right;

        p.right = c.left;
        c.left = p;

        p.height = 1 + Math.max(ht(p.left),ht(p.right));
        c.height = 1 + Math.max(ht(c.left),ht(c.right));

        return c;
    }



// level order traversal.

    public static void levelOrderTraversal(Node root){
        if(root == null) return ;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            System.out.print(current.val+" ");
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
    }
}
