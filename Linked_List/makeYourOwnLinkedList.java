import java.util.Scanner;

public class makeYourOwnLinkedList {

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static class linkedlist1{

        Node head = null;
        Node tail = null;
        int size = 0;

        void delete(int index){
            Node temp = head;

            for(int i=1;i<index;i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }


        void addAtEnd(int data){
            Node temp = new Node(data);

            if(head == null){
                head = temp;
            }
            else{
                tail.next = temp;
            }
            tail = temp;
            size++;
        }

        void display(){
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data+" -> ");
                temp = temp.next;
            }
            System.out.print("null");
            System.out.println();
        }

        int size(){
            int count =0;
            Node temp = head;
            while(temp!=null){
                count++;
                temp = temp.next;
            }
            System.out.println("Total size of the list is : " + count);
            return count;
        }

        void addAtStart(int data){
            Node temp = new Node(data);
            if(head == null){
                head = tail = temp;
            }
            else{
                temp.next = head;
                head = temp;
            }
            size++;
        }

        void addAtIndex(int index , int ele){
            Node nextToIt = new Node(ele);
            Node temp = head;

            if(index == size()){
                addAtEnd(ele);
                return;
            }

            else if(index == 0){
                addAtStart(ele);
                return;
            }


            else{
                for(int i=0;i<index;i++){
                    temp = temp.next;
                }
                nextToIt.next = temp.next;
                temp.next = nextToIt;
            }

            size++;
        }
    }


    public static void main(String[] args) {
        linkedlist1 linkedlist = new linkedlist1();
        linkedlist.addAtStart(9);
        linkedlist.addAtEnd(5);
        linkedlist.display();
        linkedlist.size();
        linkedlist.addAtEnd(6);
        linkedlist.addAtEnd(8);
        linkedlist.addAtEnd(87);
        linkedlist.display();
        linkedlist.size();

        linkedlist.addAtStart(0);
        linkedlist.addAtStart(3);
        linkedlist.display();
        linkedlist.size();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter index of the element where element is to be inserted : ");
        int index = sc.nextInt();
        System.out.print("Enter element to be inserted : ");
        int ele = sc.nextInt();
        sc.close();
        if(index < 0){
            System.out.println("Wrong index");
            return;
        }
        linkedlist.addAtIndex(index , ele);
        linkedlist.display();


        
        linkedlist.size();  //it will make time complexity of O(n).


        System.out.println("Total size of the list is : " + linkedlist.size); // it will make time complexity of O(1).


        linkedlist.delete(0);
        linkedlist.display();
        linkedlist.size();
        System.out.println("Total size of the list is : " + linkedlist.size);
        
    }
}


// if we are given only head of the linked list then for finding the size of the list will make time complexity of O(n);

// whereas if we are given linked list class then we can find its size and it will require time complexity of only O(1).