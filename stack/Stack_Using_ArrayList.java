import java.util.ArrayList;
class Stack_Using_ArrayList{
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

class Stack{
    
    ArrayList<Integer>list = new ArrayList<>();

    // this function is used to push data in out linked list
    public void push(int data){
        this.list.add(data);
    }

    // this function is used to get check stack is empty or not
    public boolean isEmpty(){
        return list.size() == 0;
    }

    // this method is  used to pop element from a stack
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        int data = list.get(list.size()-1);
        list.remove(list.size()-1);
        return data;
    }

    // this method is used to get top element of stack
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        int data = list.get(list.size()-1);
        return data;
    }
}