import java.util.Stack;
public class Next_Greater_Element {
    public static void findNextGreaterElement(int arr[], int next_greater[]){
        Stack<Integer>stack = new Stack<>();
        for(int i = arr.length-1; i>=0; i--){

            while (!stack.empty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            // here first we check stack empty
            if(stack.empty()){
                next_greater[i] = -1;
            }
            else{
                next_greater[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
    }
    public static void main(String arga[]){
        int arr[] = {6,8,0,1,3};
        int next_greater[] = new int[arr.length];

        findNextGreaterElement(arr, next_greater);

        for(int i =0; i< next_greater.length; i++){
            System.out.print(next_greater[i] +" ");
        }

    }
}
