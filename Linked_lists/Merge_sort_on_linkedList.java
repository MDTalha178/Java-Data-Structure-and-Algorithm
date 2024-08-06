import java.util.Scanner;

public class Merge_sort_on_linkedList {
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
    // here we create function to find out linked list
    public static Node getMiddleNodeOfLinkedList(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;


    }
    // here we will merge out linked left and rigth
    public static Node mergeLinkedList(Node left, Node right){
        Node temp = new Node(-1);
        Node tempLinkedList = temp;

        while(left != null && right != null){
            if(left.data <= right.data){
                tempLinkedList.next = left;
                left = left.next;
                tempLinkedList = tempLinkedList.next;
            }
            else{
                tempLinkedList.next = right;
                right = right.next;
                tempLinkedList = tempLinkedList.next;

            }
        }

        // here we will fill rest of linked list
        while(left != null){
            tempLinkedList.next = left;
            left = left.next;
            tempLinkedList = tempLinkedList.next;
        }
        while(right != null){
            tempLinkedList.next = right;
            right = right.next;
            tempLinkedList = tempLinkedList.next;
        }
        return temp.next;
    }

    public static Node sortLinkedListUsingMergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        // here we will find out mid of array of aour linked list
        Node middleNode = getMiddleNodeOfLinkedList(head);

        // here we will call mergeSort on left and right
        Node rightHead = middleNode.next;
        middleNode.next = null;
        Node left = sortLinkedListUsingMergeSort(head);
        Node right = sortLinkedListUsingMergeSort(rightHead);

        // here we will merge of our left Node linked and right Node linked list
        return mergeLinkedList(left, right);

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

        // here will sort our linked list
        Node newhead = sortLinkedListUsingMergeSort(head);
        head = newhead;
        // here we will print our linked list
        printLinkedList();
    }
}
