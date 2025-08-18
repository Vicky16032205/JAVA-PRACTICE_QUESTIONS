package Graphs.Starting_Again;

import java.util.*;

public class dijkstra_using_treeSet {

    public static class Pair{
        int dest;
        int wt;

        public Pair(int dest, int wt){
            this.dest = dest;
            this.wt = wt;
        }
    }
    
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 4}, {0, 2, 8}, {1, 4, 6}, {2,3,2}, {3, 4, 10}};
        int[] list = new int[edges.length];
        list = shortestPath(5, edges, 0);
        System.out.print("[");
        for(int ele: list){
            System.out.print(ele+ " ");
        }
        System.out.print("]");
    }

    public static int[] shortestPath(int V, int edges[][], int src) {
        int n = V;
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            list.add(new ArrayList<Pair>());
        }

        for(int i=0;i<edges.length;i++){
            list.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            list.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        int[] dist = new int[n];

        for(int i=0;i<n;i++){
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;

        TreeSet<Pair> set = new TreeSet<>((x, y) -> {
            if (x.wt == y.wt) return x.dest - y.dest;
            return x.wt - y.wt;
        });

        set.add(new Pair(src, dist[src]));

        while(!set.isEmpty()){
            Pair node = set.pollFirst();

            for(int i=0;i<list.get(node.dest).size();i++){
                int wt = list.get(node.dest).get(i).wt;
                int dest = list.get(node.dest).get(i).dest;

                if(node.wt + wt < dist[dest]){
                    set.remove(new Pair(dest, dist[dest]));
                    dist[dest] = node.wt + wt;
                    set.add(new Pair(dest, dist[dest]));
                }
            }
        }
        return dist;
    }
}