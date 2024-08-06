import java.util.Scanner;

public class Reverse_linked_list {
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
    // here we will reverse a linked list
    public static void reverseLinkedList(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            // here we perform 4 steps
            next =curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // here we update our head
        head = prev;
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

        // here we reverse a linked list
        reverseLinkedList();

        // here we print a linked list after reverse
        printLinkedList();

    }
}
