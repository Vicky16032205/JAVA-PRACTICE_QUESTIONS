package Graphs;

import java.util.ArrayList;

public class cycleDetection {
    public static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    public static boolean detection(ArrayList<Edge>[] graph , int curr , boolean[] vis , boolean[] pathVis){
        vis[curr] = true;
        pathVis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            if(pathVis[e.dest]){
                return true;
            }
            if(!vis[e.dest] && detection(graph, e.dest, vis, pathVis)){
                return true;
            }
        }

        pathVis[curr] = false;
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v =4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        System.out.println(detection(graph,0, new boolean[v] , new boolean[v] ));
    }
}





// Code for finding the cycle if present in a directed graph.