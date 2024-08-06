import java.util.Queue;
import java.util.Stack;
public class Queue_UsingTwoStack {
    public static void main(String arags[]){
        CutomQueue queue = new CutomQueue();

        // here we will add
        queue.addElement(1);
        queue.addElement(2);
        queue.addElement(3);
        queue.addElement(4);

        // here we will get front
        System.out.println("Front element: " + queue.peek());

        // here we will remove
        int value = queue.pop();
        System.out.println("Deleted value is "+ value);

        // here we will get front
        System.out.println("Front element: " + queue.peek());

    }
}

class CutomQueue{
    Stack<Integer>stack1 = new Stack<>();
    Stack<Integer>stack2 = new Stack<>();

    //method is used to get is Queue is Empty
    public boolean isEmpty(){
        return stack1.empty();
    }
    public void addElement(int data){
        // here we need to is stack 1 is empty
        if(stack1.empty()){
            stack1.add(data);
        }else{
            // here transefer all data to stack2
            while(!stack1.empty()){
                stack2.add(stack1.peek());
                stack1.pop();
            }
            stack1.add(data);

            // here we will copy all data to back in stack 1
            while (!stack2.empty()) {
                stack1.add(stack2.peek());
                stack2.pop();
            }
        }
    }

    // here will pop
    public int pop(){
        if(stack1.empty()){
            System.out.println("Stack is Empty");
            return -1;
        }else{
            return stack2.pop();
        }
    }

    // here we get our peek element
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }else{
            return stack1.peek();
        }
    }

}

