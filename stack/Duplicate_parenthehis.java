import java.util.Stack;
public class Duplicate_parenthehis {
    
    public static boolean isDuplicateParentheis(String str){
        Stack<Character>stack = new Stack<>();

        for(int i=0; i< str.length(); i++){
            char currentChar = str.charAt(i);

            if(currentChar == ')'){
                int count =0;
                while(stack.peek() != '('){
                    count++;
                    stack.pop();
                }
                if(count < 1){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(currentChar);
            }
        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }

    public static void main(String args[]){
    String str = "(a+b)";
    boolean is_valid = isDuplicateParentheis(str);
    if(is_valid){
        System.out.println("Given not Containing Duplicate Parenthesis");
    }else{
        System.out.println("Given String Containing duplicate Parantehis");
    }
    }
    
}
