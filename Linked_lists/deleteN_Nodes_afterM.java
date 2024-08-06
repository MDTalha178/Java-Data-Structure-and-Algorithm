import java.util.Scanner;

/**
 * deleteN_Nodes_afterM
 */
public class deleteN_Nodes_afterM {
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

    // here we will delete a node
    public static void deleteNafterMNodes(int n, int m){
        if(head == null){
            return;
        }
        if(n + m > size){
            System.out.println("Linked list out of bound");
            return;
        }
        if( n== 0){
            head = null;

        }
        int start = 0;
        Node prev = null;
        Node curr = head;
        while(curr != null){
            if(start == n-1){
                prev = curr;
                int delete_nodes = 0;
                while(delete_nodes <= m){
                    curr = curr.next;
                    delete_nodes++;
                }
                prev.next = curr;
                break;
            }
            start++;
            curr = curr.next;
        }
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

    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter a size for linked list");
        int linked_list_size = sc.nextInt();

        // here we will add element in a linked list
        addElementInLinkedList(linked_list_size);

        // here we will call a method to print linked list
        printLinkedList();

        // 
        System.out.println("Enter number after how many element you want to delete");
        int after_number_of_node = sc.nextInt();
        System.out.println("Enter number after number of nodes to be deleted");
        int delete_number_of_node = sc.nextInt();
        deleteNafterMNodes(after_number_of_node, delete_number_of_node);

        // here we will print our linked list
        printLinkedList();
    }
    
}