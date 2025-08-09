package Graphs.Starting_Again;

import java.util.*;

public class undirect_shortest_path_unit_wt {

    public static class Pair{
        int node;
        int wt;
        
        public Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }

    public static int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int[] ans = new int[adj.size()];
        Queue<Pair> queue = new LinkedList<>();
        
        for(int i=0;i<ans.length;i++){
            ans[i] = Integer.MAX_VALUE;
        }
        ans[src] = 0;
        
        queue.add(new Pair(src, ans[src]));
        
        while(!queue.isEmpty()){
            Pair node = queue.poll();
            int val = node.node;
            
            for(int i=0;i<adj.get(val).size();i++){
                int ele = adj.get(val).get(i);

                if(ans[val] + 1 < ans[ele]){
                    ans[ele] = ans[val] + 1;
                    queue.add(new Pair(ele, ans[ele]));
                }
            }
        }
        
        for(int i=0;i<ans.length;i++){
            if(ans[i] == Integer.MAX_VALUE) ans[i] = -1;
        }
        
        return ans;
    }

    public static void main(String[] args) {
        // Test 1: Square graph (original)
        System.out.println("Test 1: Square graph");
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i < 4; i++) adj1.add(new ArrayList<>());
        adj1.get(0).add(1); adj1.get(1).add(0);
        adj1.get(0).add(3); adj1.get(3).add(0);
        adj1.get(1).add(2); adj1.get(2).add(1);
        adj1.get(2).add(3); adj1.get(3).add(2);
        int[] result1 = shortestPath(adj1, 0);
        System.out.println("Shortest distances from source 0: " + Arrays.toString(result1));
        System.out.println();

        // Test 2: Disconnected graph
        System.out.println("Test 2: Disconnected graph");
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) adj2.add(new ArrayList<>());
        adj2.get(0).add(1); adj2.get(1).add(0);
        adj2.get(2).add(3); adj2.get(3).add(2);
        // Node 4 is isolated
        int[] result2 = shortestPath(adj2, 0);
        System.out.println("Shortest distances from source 0: " + Arrays.toString(result2));
        System.out.println();

        // Test 3: Line graph
        System.out.println("Test 3: Line graph");
        ArrayList<ArrayList<Integer>> adj3 = new ArrayList<>();
        for (int i = 0; i < 4; i++) adj3.add(new ArrayList<>());
        adj3.get(0).add(1); adj3.get(1).add(0);
        adj3.get(1).add(2); adj3.get(2).add(1);
        adj3.get(2).add(3); adj3.get(3).add(2);
        int[] result3 = shortestPath(adj3, 0);
        System.out.println("Shortest distances from source 0: " + Arrays.toString(result3));
        System.out.println();

        // Test 4: Single node graph
        System.out.println("Test 4: Single node graph");
        ArrayList<ArrayList<Integer>> adj4 = new ArrayList<>();
        adj4.add(new ArrayList<>());
        int[] result4 = shortestPath(adj4, 0);
        System.out.println("Shortest distances from source 0: " + Arrays.toString(result4));
        System.out.println();

        // Test 5: Star graph
        System.out.println("Test 5: Star graph");
        ArrayList<ArrayList<Integer>> adj5 = new ArrayList<>();
        for (int i = 0; i < 5; i++) adj5.add(new ArrayList<>());
        for (int i = 1; i < 5; i++) {
            adj5.get(0).add(i);
            adj5.get(i).add(0);
        }
        int[] result5 = shortestPath(adj5, 0);
        System.out.println("Shortest distances from source 0: " + Arrays.toString(result5));
        System.out.println();
    }
}