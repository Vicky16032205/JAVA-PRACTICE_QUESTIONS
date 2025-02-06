package Recursion;

public class frogJump {

    static int min(int[] h , int n , int idx){
        if(idx == n-1) return 0;
        int jump1 = min(h, n, idx+1) + Math.abs(h[idx] - h[idx+1]);
        if(idx == n-2) return jump1;
        int jump2 = min(h, n, idx+2) + Math.abs(h[idx] - h[idx+2]);
        return Math.min(jump1, jump2);
    }

    public static void main(String[] args) {
        int[] h = {10,30,40,20,50};
        System.out.println(min(h,h.length,0));
    }
}