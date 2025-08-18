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
        int[][] edges = {{0, 1, 4}, {0, 2, 8}, {1, 4, 6}, {2,3,2}, {3, 4, 10}};
        int n = 5;
        int m = 5;

        int[] list = new int[n];
        list = shortestPath(n, m, edges);

        List<Integer> res = new ArrayList<>();
        int j = n-1;
        while(j != 0){
            res.add(j);
            j = list[j];
        }
        res.add(0);

        for(int i=res.size()-1;i>=0;i--){
            System.out.print(res.get(i)+" ");
        }
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
