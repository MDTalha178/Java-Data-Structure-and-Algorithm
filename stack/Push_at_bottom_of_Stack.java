
/**
 * Problem: Add element in stack at the bottom
 * Solution: This class will implement the solution of adding element in stack at the bottom
 * @author MD Talha
 *
 */
import java.util.Stack;
    
public class Push_at_bottom_of_Stack {
    // here we will add element in stack at bottom
    public static void addElementInstackAtBottom(Stack<Integer>stack, int data){
        if(stack.empty()){
            stack.push(data);
            return;
        }
        int pop = stack.pop();
        addElementInstackAtBottom(stack, data);
        stack.push(pop);
    }
    public static void main(String args[]){
        Stack<Integer>stack = new Stack<>();

        // here we will push element in stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // add element at bottom
        addElementInstackAtBottom(stack, 19);

         //here we will get our top element
        System.out.println("Top element of stack is " + stack.peek());

        // here we will delete element from stack
        while (!stack.isEmpty()) {
            int data = stack.pop();
            System.out.println("Pop Data is" + data);
        }

 
    }
}



