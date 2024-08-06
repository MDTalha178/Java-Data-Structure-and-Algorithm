class Stack_Using_LinkedList{
    public static void main(String args[]){
        Stack stack = new Stack();

        // here we will push element in stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        //here we will get our top element
        System.out.println("Top element of stack is " + stack.peek());

        // here we will delete element from stack
        while (!stack.isEmpty()) {
            int data = stack.pop();
            System.out.println("Pop Data is" + data);
        }

        System.out.println("Top element of stack is " + stack.peek());
    }
}

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class Stack{
    static Node head = null;

    // here we will push element in linked list for stack
    public void push(int data){
        // fisrt create a node
        Node newNode = new Node(data);

        // here firts we check head is null
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // here we will check out stack or linked list is empty
    public boolean isEmpty(){
        return head == null;
    }

    // here we will delete element from linked list for stack
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        int data = head.data;
        head = head.next;
        return data;
    }

    // here we will get our top element
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return head.data;
    }
}