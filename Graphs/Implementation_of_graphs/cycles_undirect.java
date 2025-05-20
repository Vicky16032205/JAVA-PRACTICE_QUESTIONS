package Graphs.Implementation_of_graphs;

import java.util.*;

public class cycles_undirect {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{1,2},{2,3}};
        int V  = edges.length;
        System.out.println(isCycle(edges , V));
    }

    @SuppressWarnings("unchecked")
    public static boolean isCycle(int[][] edges , int V){
        // implement code here.
        ArrayList<Integer>[] graph = new ArrayList[V];

        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<edges.length;i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }


        boolean[] vis = new boolean[V];

        for(int i=0;i<V;i++){
            if(!vis[i] && cycleExists(i,-1,vis,graph)) return true;
        }

        return false;
    }

    public static boolean cycleExists(int curr , int par , boolean[] vis , ArrayList<Integer>[] graph){
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            int neighbour = graph[curr].get(i);

            if(vis[neighbour]) return true;
            if(curr == par) continue;
            else{
                if(cycleExists(neighbour, curr, vis, graph)) return true;
            }
        }
        return false;
    }
}

// This is coding problem for finding the cycles in undirected graphs.
// problem: Undirected Graph Cycle

// This is implementation using the recursion logic i.e., DFS