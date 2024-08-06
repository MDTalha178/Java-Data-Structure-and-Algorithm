import java.util.Scanner;

public class Remove_nth_node_from_end {
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
    // here we will remove element  nth node from end
    public static int removeNthNodeFromEnd(int index){
        if(index > size){
            System.out.println("Index out of bound");
            return -1;
        }
        int start = 0;
        int end = size - index;
        Node curr = head;
        Node prev = null;
        while(start < end){
            prev = curr;
            curr = curr.next;
            start++;
        }
        int val = curr.data;
        prev.next = curr.next;
        return val;

    }
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
        addElementInLinkedList(5);

        // print our linked list
        printLinkedList();

        // here we will remove 2nd node from end
        int remove = removeNthNodeFromEnd(3);
        System.out.println(remove);

        // here we will print our linked list
        printLinkedList();
    }
}
