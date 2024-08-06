import java.util.Scanner;

public class SwappingNode {
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

    // here we will swap our Nodes
    public static void swapNodes(){
        Node curr = head.next;
        Node prev = head;
        while (curr != null && curr.next != null) {
            Node first = curr;
            Node second = curr.next;
            // Swapping nodes
            prev.next = second; // The node before the first node now points to the second node
            first.next = second.next; // The first node now points to the node after the second node
            second.next = first; // The second node now points to the first node
            
            // Move to the next pair
            prev = first;
            curr = first.next;
        }   
    }

    // here we will print a linked list
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

        // here we will swap out nodes
        swapNodes();

        // here we will print our linked list after swaping
        printLinkedList();
    }
}
