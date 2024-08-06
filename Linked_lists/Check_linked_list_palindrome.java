import java.util.Scanner;

public class Check_linked_list_palindrome {

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
    // here we will find out middle node of our linked list
    public static Node findMiddlNode(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node reverseHalfLinkedList(Node revrserHead){
        if(revrserHead == null){
            return revrserHead;
        }
        Node prev =null;
        Node curr = revrserHead;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // revrserHead.next = null;
        return prev;

    }
    // here we will check linked list is palindrome
    public static boolean isLinkedListIsPalindrom(){
        if(head == null || head.next == null){
            return true;
        }
        Node middleNode = findMiddlNode();
        Node right_head = reverseHalfLinkedList(middleNode);
        Node left_head = head;

        while(right_head !=null){
            if(left_head.data != right_head.data){
                return false;
            }
            left_head = left_head.next;
            right_head = right_head.next;
        }
        return true;
    }
    // here this method is used to print out linked list
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
        addElementInLinkedList(4);

        // print our linked list
        printLinkedList();

        // here we will check linked list palindrome
        boolean is_palindrome = isLinkedListIsPalindrom();
        System.out.println(is_palindrome);
    }
}
