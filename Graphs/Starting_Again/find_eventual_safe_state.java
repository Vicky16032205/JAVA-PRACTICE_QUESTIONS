package Graphs.Starting_Again;

import java.util.*;

public class find_eventual_safe_state {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] ans = new int[n];
        boolean[] vis = new boolean[n];
        boolean[] recVis = new boolean[n];


        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i, graph, vis, recVis, ans);
            }
        }
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(ans[i] == 1) res.add(i);
        }

        return res;
    }

    public static boolean dfs(int idx, int[][] graph, boolean[] vis, boolean[] rec, int[] ans){
        vis[idx] = true;
        rec[idx] = true;

        for(int i=0;i<graph[idx].length;i++){
            if(rec[graph[idx][i]]) return false;

            else{
                if(!vis[graph[idx][i]]){
                    if(!dfs(graph[idx][i], graph, vis, rec, ans)){
                        return false;
                    }
                }
            }
        }
        ans[idx] = 1;
        rec[idx] = false;
        return true;
    }

    public static void main(String[] args) {
        // Test case 1: Basic graph with cycles and safe nodes
        int[][] graph1 = {
            {1,2},      // Node 0 -> [1,2]
            {2,3},      // Node 1 -> [2,3]
            {5},        // Node 2 -> [5]
            {0},        // Node 3 -> [0] (creates cycle)
            {5},        // Node 4 -> [5]
            {},         // Node 5 -> [] (terminal node)
            {}          // Node 6 -> [] (terminal node)
        };
        
        System.out.println("Graph 1:");
        printGraph(graph1);
        
        List<Integer> safeNodes1 = eventualSafeNodes(graph1);
        System.out.println("Safe nodes: " + safeNodes1);
        
        System.out.println();
        
        // Test case 2: All nodes are safe (no cycles)
        int[][] graph2 = {
            {1,2},      // Node 0 -> [1,2]
            {2,3},      // Node 1 -> [2,3]
            {3},        // Node 2 -> [3]
            {}          // Node 3 -> [] (terminal)
        };
        
        System.out.println("Graph 2 (no cycles):");
        printGraph(graph2);
        
        List<Integer> safeNodes2 = eventualSafeNodes(graph2);
        System.out.println("Safe nodes: " + safeNodes2);
        
        System.out.println();
        
        // Test case 3: Graph with self-loop
        int[][] graph3 = {
            {0},        // Node 0 -> [0] (self-loop)
            {2},        // Node 1 -> [2]
            {}          // Node 2 -> [] (terminal)
        };
        
        System.out.println("Graph 3 (with self-loop):");
        printGraph(graph3);
        
        List<Integer> safeNodes3 = eventualSafeNodes(graph3);
        System.out.println("Safe nodes: " + safeNodes3);
        
        System.out.println();
        
        // Test case 4: Single node graph
        int[][] graph4 = {
            {}          // Node 0 -> [] (terminal)
        };
        
        System.out.println("Graph 4 (single terminal node):");
        printGraph(graph4);
        
        List<Integer> safeNodes4 = eventualSafeNodes(graph4);
        System.out.println("Safe nodes: " + safeNodes4);
        
        System.out.println();
        
        // Test case 5: Complex graph with multiple cycles
        int[][] graph5 = {
            {1},        // Node 0 -> [1]
            {2},        // Node 1 -> [2]
            {3},        // Node 2 -> [3]
            {4},        // Node 3 -> [4]
            {1},        // Node 4 -> [1] (creates cycle 1->2->3->4->1)
            {6},        // Node 5 -> [6]
            {}          // Node 6 -> [] (terminal)
        };
        
        System.out.println("Graph 5 (complex with cycles):");
        printGraph(graph5);
        
        List<Integer> safeNodes5 = eventualSafeNodes(graph5);
        System.out.println("Safe nodes: " + safeNodes5);
    }

    public static void printGraph(int[][] graph) {
        for(int i = 0; i < graph.length; i++) {
            System.out.print("Node " + i + " -> ");
            if(graph[i].length == 0) {
                System.out.println("[] (terminal)");
            } else {
                System.out.println(Arrays.toString(graph[i]));
            }
        }
    }
}
