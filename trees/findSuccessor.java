package trees;

import java.util.*;

public class findSuccessor {
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
        findSuccessor level = new findSuccessor(sc);
        System.out.print("\nNext Successor of given key is : ");
        level.successor(14);
        System.out.print("\nprinting in alternate reverse order : ");
        level.alternate();
    }

    public findSuccessor(Scanner sc){
        System.out.print("Enter root value : ");
        this.root = new Node(sc.nextInt());
        System.out.println("enter left child of "+root.val+ " or write -1 to stop : ");
        root.left = constructTree(null,sc);
        System.out.println("enter right child of "+root.val+ " or write -1 to stop : ");
        root.right = constructTree(null, sc);


        root.height = Math.max(ht(root.left) , ht(root.right));
        System.out.println("Height of tree is : "+root.height);
    }

    public int ht(Node root){
        return (root == null)?0: root.height;
    }

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



    // printing the succcessor function implemented here.
    public void successor(int n){
        successor(n, this.root);
    }
    private void successor(int key , Node root){
        Queue<Node> queue = new LinkedList<>();
        boolean flag = false;
        queue.add(root);

        while(!queue.isEmpty()){
            Node curr = queue.poll();

            if(curr.left != null){
                queue.add(curr.left);
            }

            if(curr.right != null){
                queue.add(curr.right);
            }

            if(curr.val == key){
                flag = true;
                break;
            }
        }
        if(flag == false){
            System.out.println("No element found with given key value.");
        }
        else
            System.out.println(queue.peek().val);
    }





    // printing in alternate reverse order.
    public void alternate(){
        alternate(this.root);
    }
    private void alternate(Node root){
        if(root == null) return;

        List<List<Integer>> result = new ArrayList<>();

        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;
        while(!queue.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            int lnth = queue.size();

            for(int i=0;i<lnth;i++){
                if(!reverse){
                    Node current = queue.pollFirst();
                    curr.add(current.val);
                    if(current.left != null){
                        queue.addLast(current.left);
                    }
                    if(current.right != null){
                        queue.addLast(current.right);
                    }
                }
                else{
                    Node current = queue.pollLast();
                    curr.add(current.val);
                    if(current.right != null){
                        queue.addFirst(current.right);
                    }
                    if(current.left != null){
                        queue.addFirst(current.left);
                    }
                }
            }
            result.add(curr);
            reverse = !reverse;
        }


        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }


        // In this problem we used DEQUE for solving it. We choose deque because it helped us to make changes in each order traversal
        // as this makes it possible to add or remove from front or back of the Queue and also add in front or back of it.
    }
}
