package Graphs.Starting_Again;

import java.util.*;

public class Shortest_Path_Weighted_undirected_graph {

    public static class Pair{
        int dest;
        int wt;

        public Pair(int dest, int wt){
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Original Example
        int[][] edges1 = {{0, 1, 4}, {0, 2, 8}, {1, 4, 6}, {2,3,2}, {3, 4, 10}};
        runTest(5, 5, edges1, "Test Case 1");

        // Test Case 2: Linear Graph
        int[][] edges2 = {{0, 1, 1}, {1, 2, 1}, {2, 3, 1}, {3, 4, 1}};
        runTest(5, 4, edges2, "Test Case 2");

        // Test Case 3: Star Graph
        int[][] edges3 = {{0, 1, 2}, {0, 2, 2}, {0, 3, 2}, {0, 4, 2}};
        runTest(5, 4, edges3, "Test Case 3");

        // Test Case 4: Disconnected Graph (no path from 0 to 4)
        int[][] edges4 = {{0, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        runTest(5, 3, edges4, "Test Case 4");

        // Test Case 5: Multiple Paths, Different Weights
        int[][] edges5 = {{0, 1, 1}, {1, 4, 10}, {0, 2, 2}, {2, 3, 2}, {3, 4, 2}};
        runTest(5, 5, edges5, "Test Case 5");
    }

    public static void runTest(int n, int m, int[][] edges, String testName) {
        int[] list = shortestPath(n, m, edges);

        List<Integer> res = new ArrayList<>();
        int j = n-1;
        boolean pathExists = true;
        while(j != 0) {
            if (list[j] == -1) {
                pathExists = false;
                break;
            }
            res.add(j);
            j = list[j];
        }
        if (pathExists) {
            res.add(0);
            System.out.print(testName + " Shortest Path: ");
            for(int i=res.size()-1;i>=0;i--){
                System.out.print(res.get(i)+" ");
            }
        } else {
            System.out.print(testName + " Shortest Path: No path exists");
        }
        System.out.println();
    }

    public static List<List<Pair>> makeTree(int n, int edges[][]){
        List<List<Pair>> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new ArrayList<Pair>());
        }

        for(int i=0;i<edges.length;i++){
            int first = edges[i][0];
            int second = edges[i][1];
            int third = edges[i][2];

            list.get(first).add(new Pair(second, third));
            list.get(second).add(new Pair(first, third));
        }

        return list;
    }

    public static int[] shortestPath(int n, int m, int edges[][]) {
        List<List<Pair>> list = new ArrayList<>();
        list = makeTree(n, edges);

        int[] direc = new int[n];
        int dist[] = new int[n];

        Arrays.fill(dist, (int)(1e9));
        Arrays.fill(direc, -1);
        dist[0] = 0;

        TreeSet<Pair> set = new TreeSet<>((x, y) -> {
            if (x.wt == y.wt) return x.dest - y.dest;
            return x.wt - y.wt;
        });
        set.add(new Pair(0, 0));

        while(!set.isEmpty()){
            Pair node = set.pollFirst();

            for(int i=0;i<list.get(node.dest).size();i++){
                int dest = list.get(node.dest).get(i).dest;
                int wt = list.get(node.dest).get(i).wt;

                if(wt + node.wt < dist[dest]){
                    set.remove(new Pair(dest, dist[dest]));
                    dist[dest] = wt + node.wt;
                    direc[dest]= node.dest;
                    set.add(new Pair(dest, dist[dest]));
                }
            }
        }
        return direc;
    }
}
