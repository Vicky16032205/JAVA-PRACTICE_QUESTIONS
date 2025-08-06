package Graphs.Starting_Again;

import java.util.*;

public class bipartite_graph {
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if(!colorGraph(i,color,graph,0)) return false;
            }
        }
        return true;
    }

    public static boolean colorGraph(int idx, int[] color, int[][] graph, int col){
        color[idx] = col;
        for(int i=0;i<graph[idx].length;i++){
            if(color[graph[idx][i]] == col) return false;
            if(color[graph[idx][i]] == -1 && !colorGraph(graph[idx][i], color, graph, 1-col)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Test case 1: Simple bipartite graph
        int[][] graph1 = {
            {1,3},      // Node 0 -> [1,3]
            {0,2},      // Node 1 -> [0,2]
            {1,3},      // Node 2 -> [1,3]
            {0,2}       // Node 3 -> [0,2]
        };
        
        System.out.println("Graph 1:");
        printGraph(graph1);
        
        boolean isBipartite1 = isBipartite(graph1);
        System.out.println("Is bipartite: " + isBipartite1);
        
        System.out.println();
        
        // Test case 2: Non-bipartite graph (triangle)
        int[][] graph2 = {
            {1,2},      // Node 0 -> [1,2]
            {0,2},      // Node 1 -> [0,2]
            {0,1}       // Node 2 -> [0,1] (forms triangle)
        };
        
        System.out.println("Graph 2 (triangle - not bipartite):");
        printGraph(graph2);
        
        boolean isBipartite2 = isBipartite(graph2);
        System.out.println("Is bipartite: " + isBipartite2);
        
        System.out.println();
        
        // Test case 3: Single node (bipartite)
        int[][] graph3 = {
            {}          // Node 0 -> [] (no edges)
        };
        
        System.out.println("Graph 3 (single node):");
        printGraph(graph3);
        
        boolean isBipartite3 = isBipartite(graph3);
        System.out.println("Is bipartite: " + isBipartite3);
        
        System.out.println();
        
        // Test case 4: Disconnected components (both bipartite)
        int[][] graph4 = {
            {1},        // Node 0 -> [1]
            {0},        // Node 1 -> [0]
            {3},        // Node 2 -> [3]
            {2}         // Node 3 -> [2]
        };
        
        System.out.println("Graph 4 (disconnected bipartite components):");
        printGraph(graph4);
        
        boolean isBipartite4 = isBipartite(graph4);
        System.out.println("Is bipartite: " + isBipartite4);
        
        System.out.println();
        
        // Test case 5: Even cycle (bipartite)
        int[][] graph5 = {
            {1,3},      // Node 0 -> [1,3]
            {0,2},      // Node 1 -> [0,2]
            {1,3},      // Node 2 -> [1,3]
            {0,2}       // Node 3 -> [0,2] (4-cycle)
        };
        
        System.out.println("Graph 5 (even cycle - bipartite):");
        printGraph(graph5);
        
        boolean isBipartite5 = isBipartite(graph5);
        System.out.println("Is bipartite: " + isBipartite5);
        
        System.out.println();
        
        // Test case 6: Odd cycle (not bipartite)
        int[][] graph6 = {
            {1,4},      // Node 0 -> [1,4]
            {0,2},      // Node 1 -> [0,2]
            {1,3},      // Node 2 -> [1,3]
            {2,4},      // Node 3 -> [2,4]
            {0,3}       // Node 4 -> [0,3] (5-cycle)
        };
        
        System.out.println("Graph 6 (odd cycle - not bipartite):");
        printGraph(graph6);
        
        boolean isBipartite6 = isBipartite(graph6);
        System.out.println("Is bipartite: " + isBipartite6);
    }

    public static void printGraph(int[][] graph) {
        for(int i = 0; i < graph.length; i++) {
            System.out.print("Node " + i + " -> ");
            if(graph[i].length == 0) {
                System.out.println("[] (no connections)");
            } else {
                System.out.println(Arrays.toString(graph[i]));
            }
        }
    }
}
