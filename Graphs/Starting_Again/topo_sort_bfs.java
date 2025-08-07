package Graphs.Starting_Again;

import java.util.*;

public class topo_sort_bfs {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            graph.add(new ArrayList<>());
        }
        
        graph.get(0).add(1);
        // Node 1 and 2 are terminals
        
        System.out.println("Problematic Case:");
        printGraph(graph);
        
        List<Integer> safeNodes = eventualSafeNodes(graph);
        Collections.sort(safeNodes);
        System.out.println("Safe Nodes: " + safeNodes); // Expected: [0, 1, 2]
        System.out.println();
    }

    public static List<Integer> eventualSafeNodes(List<List<Integer>> graph){
        int n = graph.size();
        List<Integer> ans = new ArrayList<>();

        // first reverse all directions 
        List<List<Integer>> rev = new ArrayList<>();
        int[] indegree = new int[n];
        
        for(int i = 0; i < n; i++){
            rev.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            int m = graph.get(i).size();
            for(int j=0;j<m;j++){
                rev.get(graph.get(i).get(j)).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        // then we will store the counting of indegree of each element.
        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                queue.add(i);
                ans.add(i);
            }
        }
        // after that put elements into queue if there indegree is 0

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i=0;i<rev.get(node).size();i++){
                indegree[rev.get(node).get(i)]--;
                if(indegree[rev.get(node).get(i)] == 0){
                    queue.add(rev.get(node).get(i));
                    ans.add(rev.get(node).get(i));
                }
            }
        }
        // atlast when queue becomes empty return the list containing all elements having indegree 0

        // before returning the list make sure that list is sorted otherwise it might give some errors

        // and you are all set.
        return ans;
    }

    public static void printGraph(List<List<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("Node " + i + " -> " + graph.get(i));
        }
    }
}
