import java.util.Stack;
public class Stock_Span {
    public static void stockSpan(int stocks[], int span[]){
        Stack<Integer>stack = new Stack<>();

        span[0] = stocks[0];
        stack.push(0);

        for(int i =1; i<stocks.length; i++){
            int currPrice = stocks[i];

            while(!stack.empty() && currPrice > stocks[stack.peek()]){
                stack.pop();
            }

            // here we will will stack is not empty
            if(stack.empty()){
                span[i] = i+1;
            }
            else{
                int prevStock = stack.peek();
                span[i] = i - prevStock;
            }
            stack.push(i);
        }
    }
    public static void main(String arga[]){
        int stocks[] = {100, 80,60, 70,85,90,100};
        int Stock_Span[] = new int[stocks.length];

        // here we will find out our span
        stockSpan(stocks, Stock_Span);

        // here we will print our span
        for(int i =0; i< Stock_Span.length; i++){
            System.out.println(Stock_Span[i]);
        }
    }
}
