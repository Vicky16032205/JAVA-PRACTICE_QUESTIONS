package trees;
import java.util.*;
public class verticalTraversal {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
    static HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    static TreeMap<Integer, ArrayList<Integer>> tree = new TreeMap<>();
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(9);
        Node b = new Node(20);
        root.left = a;
        root.right = b;
        Node e = new Node(15);
        Node f = new Node(7);
        b.left = e;
        b.right = f;
        verticalOrderTraversal(root,0);
        printTraversal();
    }

    public static void verticalOrderTraversal(Node root, int inc){
        if(root == null) return;
        // for hashmap.
        map.putIfAbsent(inc, new ArrayList<>());
        map.get(inc).add(root.data);

        // for treemap.
        tree.putIfAbsent(inc, new ArrayList<>());
        tree.get(inc).add(root.data);

        // calling recursion.
        verticalOrderTraversal(root.left, inc-1);
        verticalOrderTraversal(root.right, inc+1);
    }

    public static void printTraversal(){
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for(Integer key : list){
            System.out.println("Vertical Level "+key+": "+map.get(key));
        }

        System.out.println("\nUsing treemap\n");

        for(Map.Entry<Integer,ArrayList<Integer>> entry : tree.entrySet()){
            System.out.println("Vertical Level "+entry.getKey()+": "+entry.getValue());
        }

    }
}
