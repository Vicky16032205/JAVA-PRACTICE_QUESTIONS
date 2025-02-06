import java.util.ArrayList;
import java.util.List;

public class Majority_Element {
    public static List<Integer> findMajority(int[] nums,ArrayList<Integer> arr) {
        int n =  nums.length;
        for(int i=0;i<nums.length;i++){
            int count = 1;
            for(int j=i+1 ; j<n ; j++){
                if(nums[i] == nums[j] ){
                    count++;
                }
            }
             if(count > n/3 && !arr.contains(nums[i])){
                arr.add(nums[i]);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println(findMajority(nums , arr));
    }
}