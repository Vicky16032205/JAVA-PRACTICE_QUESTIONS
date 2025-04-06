package trees;

import java.util.*;

public class levelWiseSum {

    // creating Node class here.
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
        levelWiseSum level = new levelWiseSum(sc);
        System.out.print("in-order traversal : ");
        level.display(); 
        System.out.print("\nBreadth First Search : ");
        level.BFS();
        System.out.print("\nSum of each levels : ");
        level.sum();
        System.out.print("\nAverage of each levels : ");
        level.average();
    }


    // function for writing the logic of constructing a tree.
    public levelWiseSum(Scanner sc){
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





    // BFS function implemented here.
    public void BFS(){
        BFS(this.root , root.height);
    }
    private void BFS(Node root , int height){

        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();


        while(!queue.isEmpty()){
            int levelSize = queue.size();
            ArrayList<Integer> newCurr = new ArrayList<>(levelSize);

            for(int i=0;i<levelSize;i++){
                Node curr = queue.poll();
                newCurr.add(curr.val);
                
                if(curr.left  != null){
                    queue.add(curr.left);
                }

                if(curr.right  != null){
                    queue.add(curr.right);
                }
            }
            result.add(newCurr);
        }


        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i) + " ");
        }
    }





    // here will be calculating the sum of every levels.
    public void sum(){
        sum(this.root);
    }
    private void sum(Node root){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            int average = 0;
            for(int i=0;i<levelSize;i++){
                Node curr = queue.poll();
                average += curr.val;
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            result.add(average);
        }

        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+", ");
        }
    }




    // function to find the average of each level.
    public void average(){
        avg(this.root);
    }
    private void avg(Node root){
        ArrayList<Double> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int lngth = queue.size();
            double avg =0;

            for(int i=0;i<lngth;i++){
                Node node = queue.poll();
                avg += node.val;

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            avg = avg/lngth;
            result.add(avg);
        }

        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+", ");
        }
    }
}
