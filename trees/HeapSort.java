package trees;

import java.util.*;

public class HeapSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while(true){
            System.out.print("enter value (or -1 to stop): ");
            int x = sc.nextInt();
            if(x == -1) break;
            add(x,list);
        }
        System.out.println("Element which is smallest is: "+ list.get(0));
        delete(7, list);
        System.out.println("Element which is smallest after deletion of element 7 is: "+ list.get(0));
        sc.close();
    }

    public static void add(int x, ArrayList<Integer> list){
        list.add(x);
        int i = list.size()-1;
        while(i > 0){
            int parent = (i-1)/2;
            if(list.get(parent) > list.get(i)){
                int temp = list.get(parent);
                list.set(parent, list.get(i));
                list.set(i, temp);
                // changing new element index to its parent index for further computation.
                i = parent;
            }
            else{
                break;
            }
        }
    }

    public static void delete(int ele, ArrayList<Integer> list){
        int index = -1;
        for(int i=0;i<list.size();i++){
            if(list.get(i) == ele){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("Element not found in heap");
            return;
        }

        list.set(index, list.get(list.size()-1));
        list.remove(list.size()-1);

        int size = list.size();
        while(true){
            int left = 2*index+1;
            int right = 2*index+2;
            int smallest = index;

            if(left<size && list.get(left) <  list.get(smallest)){
                smallest = left;
            }
            if(right<size && list.get(right) <  list.get(smallest)){
                smallest = right;
            }

            if(smallest == index) break;

            int temp = list.get(index);
            list.set(index, list.get(smallest));
            list.set(smallest, temp);

            index = smallest;
        }
    }
}
