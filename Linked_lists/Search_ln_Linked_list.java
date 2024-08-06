import java.util.Scanner;

public class Search_ln_Linked_list {
    public static class Node{
        int data;
        Node next;

        // here we will create constructor
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size  = 0;

    // add element in a linked list
    public static void addElementInLinkedList(int linked_list_size){
        if(linked_list_size == 0){
            System.out.println("Please enter linked list size greater than zero");
        }
        int i =0;
        while (i < linked_list_size) {
            System.out.print("Please enter element to add in a Linked list ");
            Scanner sc = new Scanner(System.in);
            int data = sc.nextInt();
            Node newNode = new Node(data);
            if(head == null){
                head = tail = newNode;
                i++;
                size++;
            }
            else{
                tail.next = newNode;
                tail = newNode;
                i++;
                size++;
            }
        }
    }
    // here we will search an element in a linked list
    public static boolean searchElementInLinkedList(int data){
        if(size == 0){
            System.out.println("Linked list is empty");
            return false;
        }
        Node temp = head;
        while(temp != null){
            if(temp.data == data){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public static boolean helper(int data, Node temp){
        if(temp == null){
            return false;
        }
        if(temp.data == data){
            return true;
        }
        return helper(data, temp.next);
    }
    // here we will search an element in a linked list using recursive
    public static boolean searchElementInLinkedListUsingRecursion(int data){
        if(size == 0){
            return false;
        }
        Node temp = head;
        return helper(data, temp);
    }
    // here we will create a method to print a linked list
    public static void printLinkedList(){
        if(size == 0){
            System.out.println("Linked list is empty");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter a size for linked list");
        int linked_list_size = sc.nextInt();

        // here we will add element in a linked list
        addElementInLinkedList(linked_list_size);

        // here we will call a method to print linked list
        printLinkedList();

        // here we will check element is present in our linked list using ittrative
        boolean is_present = searchElementInLinkedList(13);
        if(is_present){
            System.out.println("Yes element is present in our Linked list");
        }
        else{
            System.out.println("No element is not present our linked list");
        }

        // here we solving using recursion
        boolean is_present_recur = searchElementInLinkedListUsingRecursion(6);
        if(is_present_recur){
            System.out.println("Yes element is present in our Linked list");
        }
        else{
            System.out.println("No element is not present our linked list");
        }
    }
}
