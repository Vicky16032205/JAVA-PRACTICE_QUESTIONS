public class countMax {
    public static void main(String args[]){
        int[] arr = {1,1,0,1,1,1,1,0,1,0,1};
        int max_count = Integer.MIN_VALUE;
        int count = 0;

        for(int i =0 ; i<arr.length ; i++){
            if(arr[i] == 1){
                count++;
            }
            else{
                count = 0;
            }

            max_count = Math.max(count, max_count);
        }
        System.out.println(max_count);
    }
}
