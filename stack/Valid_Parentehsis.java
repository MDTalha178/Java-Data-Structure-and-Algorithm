import java.util.Stack;
public class Valid_Parentehsis {
    public static boolean isValidParentheis(String str){
        Stack<Character>stack =  new Stack<>();
        if(str.length() == 0){
            return true;
        }
        for(int i = 0; i< str.length(); i++){

            // here we check is opening character
            char currentChar = str.charAt(i);
            if(currentChar == '('  || currentChar == '{' || currentChar == '['){
                stack.push(currentChar);
            }
            else{
                if(!stack.empty()){
                    char top = stack.peek();
                    if(currentChar == ')' & top == '(' || currentChar == '}' && top == '{' || currentChar == ']' && top == '['){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        
        // here ww check stack is still not empty
        if(!stack.empty()){
            return false;
        }
        return true;
    }
    public static void main(String args[]){
        String str = "({[()]})";
        boolean is_valid = isValidParentheis(str);
        if(is_valid){
            System.out.println("Given Parenthesis is valid");
        }else{
            System.out.println("Given Parantehis is not valid");
        }
    }
}
