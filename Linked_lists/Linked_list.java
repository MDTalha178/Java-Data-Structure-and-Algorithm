class Linked_list{
    public static class Node{
        int data;
        Node next;

        // create constructor
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    // here we define our head and tail
    public static Node head;
    public static Node tail;
    public static int size = 0;

    // here we will create a method to add element in add first in linked list
    public static void addElementAtFirst(int data){
        // here we create a node
        Node newNode = new Node(data);
        size++;
        // here we need to check head is null
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // here we will create method to add a element at last
    public static void addElementAtLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;


    }
    // here will create method  print linked list
    public static void printLinkedList(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String args[]){
        // here we are adding element at first
        addElementAtFirst(1);
        addElementAtFirst(2);
        addElementAtFirst(3);

        // here we are adding element in last
        addElementAtLast(4);
        addElementAtLast(5);
        addElementAtLast(6);

        // here we print our linked list
        printLinkedList();

        // here we will get our size
        System.out.println("Size of Linked List is " + size);
    }
}