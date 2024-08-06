public class Remove_element {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size = 0;

    // here we will add element in linked list
    public static void addElementInLinkedList(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // here we will remove element from head
    public static int removeElementFromhead(){
        if(head == null){
            System.out.print("Linked list is empyt");
            return -1;
        }
        int remove_ele = head.data;
        if(size == 1){
            head = tail = null;
            size--;
            return remove_ele;
        }
        head = head.next;
        size--;
        return remove_ele;
    }
    // here we will remove element from tail
    public static int removeElementFromTail(){
        int val = tail.data;
        if(head == null){
            System.out.println("Linked list empty");
            return -1;
        }
        if(size == 1){
            head = tail =null;
            size--;
            return val;
        }
        Node prev = head;
        for(int i =0; i<size-2; i++){
            prev = prev.next;
        }
        prev.next = null;
        tail = prev;
        size --;
        return val;
    }
    // here we will print our linked list
    public static void printLinkedList(){
        Node temp = head;
        if(head == null){
            System.out.println("Linked List is Empty");
            return;
        }
        while(temp != null){
            System.out.print(temp.data + " ->");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String args[]){
        // here add element in linked list
        addElementInLinkedList(1);
        addElementInLinkedList(2);
        addElementInLinkedList(3);
        addElementInLinkedList(4);

        // here we print before removing
        printLinkedList();

        // here we remove element from linked list
       int data = removeElementFromhead();
       System.out.println("Data remove from head "+ data);

        // here we print linked list after remove
        printLinkedList();

        // here we will remove element from tail
        int remove_from_tail = removeElementFromTail();
        System.out.println("Remove data from tail "+ remove_from_tail);

        // here we will print again linked list after remova from tail
        printLinkedList();
    }
}
