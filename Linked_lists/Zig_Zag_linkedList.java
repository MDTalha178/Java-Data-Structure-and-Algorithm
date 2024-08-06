import java.util.Scanner;

public class Zig_Zag_linkedList {
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
    // get middle element of linked list
    public static Node getMiddleNodeOfLinkedList(){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // here we need to reverse our linked list
    public static Node reverseLinkedList(Node rightNode){
        System.out.println(rightNode.data);
        Node prev = null;
        Node curr = rightNode;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
        }
        return prev;
    }
    // here we will make our list as zig zag
    public static void makeLinkedListZigZag(){
        
        // here we will get our middle node
        Node middleNode = getMiddleNodeOfLinkedList();
        // here will rever our linked lisd from middle node to end
        Node rightNode = middleNode.next;
        middleNode.next = null;
        Node righthead = reverseLinkedList(rightNode);

        // here we will update our linked list
        Node left = head;
        Node nextleft, nextRight;
        while(left != null && righthead != null){
            nextleft = left.next;
            left.next = righthead;
            nextRight = righthead.next;
            righthead.next = nextleft;

            left = nextleft;
            righthead = nextRight;

        }

        // here we will update of our rest elemenet of our linked list
        while (righthead !=null) {
            left.next = righthead;
            righthead = righthead.next;
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

        // here we make a linked list as zig zag
        makeLinkedListZigZag();

        // here we will print out list
        printLinkedList();
    }
}
