package ArrayList;

import java.util.ArrayList;
import java.util.Collections;
public class collectionSorting{

    static void sort(ArrayList<Integer> l1){
        Collections.sort(l1);
        System.out.println("Ascending Sorting : "+l1);
        Collections.reverse(l1);
        System.out.println("Descending Order : "+ l1);
        
        

        ArrayList<String> l2 = new ArrayList<>();
        l2.add("Welcome");
        l2.add("To");
        l2.add("World");
        l2.add("Of");
        l2.add("Coding");
        System.out.println("Original String : "+ l2);
        Collections.sort(l2);
        System.out.println("Sorting in ascending order on Strings : "+ l2);
        Collections.reverse(l2);
        System.out.println("Sorting in descending order on Strings : "+ l2);
    }


    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(5);
        l1.add(6);
        l1.add(7);
        l1.add(8);
        l1.add(9);
        l1.add(2);
        System.out.println("Original list " + l1);
        Collections.reverse(l1);
        System.out.println("Reverse Order : "+l1);
        sort(l1);
    }
}
