import java.util.Scanner;

public class Detect_loop_cycle {
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
        // here we are making our list as cycle
        tail.next = head;
    }
    // here we will detcted
    public static boolean isLoopCycleDetected(){
        if(head == null){
            return false;
        }
        if(size == 1){
            return false;
        }
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // here we will check if slow and fast is equal at any point
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter a size for linked list");
        int linked_list_size = sc.nextInt();

        // here we will add element in a linked list
        addElementInLinkedList(linked_list_size);


        // here we will detect a loop cycle in linked list
        boolean is_loop_cycle_detected = isLoopCycleDetected();
        if(is_loop_cycle_detected){
            System.out.println("Yes in your linked list loop cycle detceted");
        }else{
            System.out.println("No in your loop cycle is dettected");
        }
    }
}
