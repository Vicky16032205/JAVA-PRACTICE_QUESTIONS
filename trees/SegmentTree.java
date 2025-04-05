package trees;

public class SegmentTree {
    public static class Node{
        int val;
        int startRange;
        int endRange;
        Node left;
        Node right;

        public Node(int startRange , int endRange){
            this.startRange = startRange;
            this.endRange = endRange;
        }
    }

    Node root;
    public SegmentTree(int[] arr){
        this.root = constructTree(arr , 0 , arr.length-1);
    } 

    public Node constructTree(int[] arr , int start,  int end){
        if(start == end){
            Node node = new Node(start,end);
            node.val = arr[start];
            return node;
        }

        Node node = new Node(start, end);

        int mid = (start + end)/2;
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid+1, end);

        node.val = node.left.val + node.right.val;
        return node;
    }

    public int range(int st , int end){
        return this.range(this.root , st , end);
    }
    private int range(Node root , int st , int end){
        if(root.startRange >= st && root.endRange <= end){
            return root.val;
        }

        else if(end < root.startRange || st > root.endRange){
            return 0;
        }
        else{
            return range(root.left, st, end) + range(root.right, st, end);
        }
    }

    public void update(int index, int change){
        update(root,index,change);
    }

    private void update(Node root, int index, int change) {
        if(root.startRange == index || root.endRange == index){
            root.val = change;
            return;
        }
        int mid = (root.startRange + root.endRange)/2;

        if(mid >= index){
            update(root.left, index, change);
        }
        else{
            update(root.right, index, change);
        }
        root.val = root.left.val + root.right.val;
    }

    public static void main(String[] args) {
        int[] arr = {3,8,7,6,-2,-8,4,9};
        SegmentTree tree = new SegmentTree(arr);
        int n = tree.range(2,7);
        System.out.println("Sum of elements in this intervial is: "+n);
        tree.update(5,45);
        System.out.println("Sum of elements in this intervial is: "+ tree.range(2,7));
        System.out.println("Sum of elements in this intervial is: "+ tree.range(2,6));
    }
}
