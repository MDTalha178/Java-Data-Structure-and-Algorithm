public class Stack_UsingLinkedList {
    public static void main(String arags[]){
        CutomQueue queue = new CutomQueue();

        // here we will add
        queue.addElement(1);
        queue.addElement(2);
        queue.addElement(3);
        queue.addElement(4);

        // here we will get front
        System.out.println("Front element: " + queue.peek());

        // here we will get our rear element
        System.out.println("Rear elemenet "+  queue.getRear());

        // here we will remove
        int value = queue.pop();
        System.out.println("Deleted value is "+ value);

        // here we will get front
        System.out.println("Front element: " + queue.peek());

        // here we will get our rear element
        System.out.println("Rear elemenet "+  queue.getRear());
    }
}

// here define our Node class
class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

// here we define our Queue class
class CutomQueue{
    public static Node head;
    public static Node tail;

    // here we check queue is empty 
    public static boolean isEmpty(){
        return head == null;
    }

    // here we get front or top elemeent 
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return head.data;
    }

    // here we add data in queue in or linked list
    public void addElement(int data){
        Node newNode = new Node(data);

        if(head == null){
            tail = head = newNode;
            return;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    // here we will get rear element
    public int getRear(){
        if(head == null){
            System.out.println("Queue is Empty");
            return -1;
        }else{
            return tail.data;
        }
    }

    // here we can remove data from queue
    public int pop(){
        if(head == null){
            System.out.println("Queue is Empty");
            return -1;
        }else{
            int data = head.data;
            head = head.next;
            return data;
        }
    }
}
