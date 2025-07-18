package DP;

public class jumpGameIII {
    public static void main(String[] args) {
        int[] arr = {3,0,2,1,2};
        boolean[] vis = new boolean[arr.length];
        Boolean[] vis2 = new Boolean[arr.length];
        int start = 2;
        System.out.println(canReach(arr, start, vis));
        System.out.println(UsingDP(arr, start, vis2));
    }

    public static boolean UsingDP(int[] arr, int start, Boolean[] vis){
        if(start < 0 || start >= arr.length ) return false;
        if(vis[start] != null) return vis[start];
        if(arr[start] == 0) return true;
        vis[start] = false;

        int reach1 = start + arr[start];
        int reach2 = start - arr[start];
        return vis[start] = UsingDP(arr, reach1, vis) || UsingDP(arr, reach2, vis);
    }

    public static boolean canReach(int[] arr, int start, boolean[] vis){
        if(start < 0 || start > arr.length-1 || vis[start]) return false;
        if(arr[start] == 0) return true;
        vis[start] = true;

        int reach1 = start + arr[start];
        int reach2 = start - arr[start];
        return canReach(arr, reach1, vis) || canReach(arr, reach2, vis);
    }
}