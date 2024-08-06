import java.util.Stack;
public class Decode_String {
    public static String deCodeString(String str){
        Stack<Character>stack = new Stack<>();
        Stack<Character>ch = new Stack<>();
        String ans = "";
        for(int i =0; i<str.length(); i++){
            char currentChar = str.charAt(i);

            // if closing tag
            if(currentChar == ']'){
                while (stack.peek() != '[') {
                    if(stack.peek() != '['){
                        ch.push(stack.peek());
                    }
                    stack.pop();
                }
                stack.pop();
                int character_count = stack.peek() - '0';
                stack.pop();

                // get current string
                String curreString = "";
                while(!ch.empty()){
                    curreString += ch.peek();
                    ch.pop();
                }
                ans = curreString + ans;
                int j = 0;
                while(j< character_count -1){
                    ans += ans;
                    j++;

                }

            }else{
                stack.push(currentChar);
            }
        }
        return ans;
    }
    public static void main(String args[]){
        String str = "3[b2[v]]L";

        String decodedString = deCodeString(str);
        System.out.println("Decoded String: " + decodedString);

    }
}
