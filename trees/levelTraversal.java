package trees;

public class levelTraversal {

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
        Node f = new Node(7);
        b.left = e;
        b.right = f;

        // this is a iterative and recursive combined approach to print elements of each level.
        // iterative for providing inputs for levels 
        // and recursive for printing and finding elements of that particular level.
        int height = Nodeheight(root);
        for(int i=1;i<=height+1;i++){
            traverse(root , i);
            System.out.println();
        }
    }

    public static int Nodeheight(Node root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        return 1 + Math.max(Nodeheight(root.left) , Nodeheight(root.right));
    }

    public static void traverse(Node root , int n){
        if(root == null) return;
        if(n==1){
            System.out.print(root.data + " ");
            return;
        }
        traverse(root.left, n-1);
        traverse(root.right, n-1);
    }
}
