import java.util.Scanner;

class matchString{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String[] s = new String[m];
        for(int i=0;i<m;i++){
            s[i] = sc.next();
        }
        
        int n = sc.nextInt();
        String[] q = new String[n];
        for(int i=0;i<n;i++){
            q[i] = sc.next();
        }
        sc.close();
        match(m,n, s, q);
    }

    private static void match(int m, int n, String[] s, String[] q) {
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<m;j++){
                if(q[i].equals(s[j])) count++;
            }
            arr[i] = count;
        }

        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }

    
}