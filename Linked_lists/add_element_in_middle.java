public class add_element_in_middle {
    public static class Node{
        int data;
        Node next;

        // creating constructor
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size =0 ;
    public static void addElementInLinkedList(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }
    // here we will create method add element in list
    public static void addElementInMiddle(int data, int indx){
        if(indx > size){
            System.out.println("Index out of bound");
            return;
        }
        Node newNode = new Node(data);
        if(size == 0){
            head = tail = newNode;
            size++;
        }
        size++;
        int i = 0;
        Node temp = head;
        while(i < indx - 1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

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
        // here we are adding data in linked list
        addElementInLinkedList(1);
        addElementInLinkedList(2);
        addElementInLinkedList(3);
        addElementInLinkedList(4);

        // here we are pritning our linked list
        printLinkedList();

        // here we will add data at index 2
        addElementInMiddle(13, 2);
        addElementInMiddle(14, 3);
        addElementInMiddle(14, 12);

        // here we will again print
        printLinkedList();



    }
}
