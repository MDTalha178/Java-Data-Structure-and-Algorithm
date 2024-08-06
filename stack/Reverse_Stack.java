
/**
 * Problem: Reverse Stack
 * 
 * Solution: This class will implement the solution of reversing a stack
 * 
 * @author MD Talha
 *
 */

 import java.util.Stack;
public class Reverse_Stack {
    public static void helper(Stack<Integer>stack, int top){
        if(stack.empty()){
            stack.push(top);
            return;
        }
        int pop = stack.pop();
        helper(stack, top);
        stack.push(pop);
    }
    public static void reverseStack(Stack<Integer>stack){
        if(stack.empty()){
            return;
        }
        int top = stack.peek();
        stack.pop();
        reverseStack(stack);
        helper(stack, top);

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
        reverseStack(stack);
    
        //here we will get our top element
        System.out.println("Top element of stack is " + stack.peek());
    }
   
}

