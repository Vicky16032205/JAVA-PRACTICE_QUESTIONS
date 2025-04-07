package trees;

import java.util.*;

public class SymmetricTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        int height;

        public Node(int val){
            this.val = val;
            this.height = 0;
        }
    } 

    Node root;

    // main function.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SymmetricTree level = new SymmetricTree(sc);
        System.out.print("in-order traversal : ");
        level.display();
        System.out.print("\nIs the tree symmetric : ");
        level.isSymmetric();
    }


    // function for writing the logic of constructing a tree.
    public SymmetricTree(Scanner sc){
        System.out.print("Enter root value : ");
        this.root = new Node(sc.nextInt());
        System.out.println("enter left child of "+root.val+ " or write -1 to stop : ");
        root.left = constructTree(null,sc);
        System.out.println("enter right child of "+root.val+ " or write -1 to stop : ");
        root.right = constructTree(null, sc);


        root.height = Math.max(ht(root.left) , ht(root.right));
        System.out.println("Height of tree is : "+root.height);
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


    // finding height.
    public int ht(Node root){
        return (root == null)?0: root.height;
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

        node.height = 1 + Math.max(ht(node.left), ht(node.right));

        return node;
    }

    public void isSymmetric(){
        isSymmetric(this.root);
    }
    private void isSymmetric(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        boolean symmetric = true;

        while(!queue.isEmpty()){
            Node left = queue.poll();
            Node right = queue.poll();

            if(left == null && right == null) continue;
            if((left == null && right != null)||(left != null && right == null)) {
                symmetric = false;
                break;
            }

            if(left.val != right.val){
                symmetric = false;
                break;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        if(symmetric == false){
            System.out.println("Not symmetric");
        }
        else{
            System.out.println("Symmetric");
        }
    }
}
