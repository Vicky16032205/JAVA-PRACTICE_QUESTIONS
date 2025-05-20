package Graphs.Implementation_of_graphs;

import java.util.ArrayList;

public class cycles_directed {
    public static void main(String[] args) {
        // int[][] edges = {{0,1},{0,2},{1,2},{2,3}}; //not cyclic
        int[][] edges = {{0,1},{0,2},{1,2},{2,0},{2,3}}; // is cyclic in nature.
        int V  = edges.length;
        System.out.println(isCycle(edges , V));
    }

    @SuppressWarnings("unchecked")
    public static boolean isCycle(int[][] edges , int V){
        ArrayList<Integer>[] graph = new ArrayList[V];
        for(int i=0;i<V;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<edges.length;i++){
            graph[edges[i][0]].add(edges[i][1]);
        }

        boolean[] vis = new boolean[V];
        boolean[] recVis = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i] && CycleExists(i,vis,recVis,graph)) return true;
        }
        return false;
    }

    public static boolean CycleExists(int curr, boolean[] vis, boolean[] recVis, ArrayList<Integer>[] graph){
        vis[curr] = true;
        if(recVis[curr]) return true;
        
        for(int i=0;i<graph[curr].size();i++){
            recVis[curr] = true;
            int neighbour = graph[curr].get(i);
            if(recVis[graph[curr].get(i)]) return true;

            if(!recVis[neighbour] && CycleExists(neighbour, vis, recVis, graph)) return true;

            recVis[curr] = false;
        }
        return false;
    }
}



// this is problem for finding whether a directed graph contains a cycle or not.
// this is problem on GFG : Directed Graph Cycle