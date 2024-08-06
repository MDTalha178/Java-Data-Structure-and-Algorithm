public class keypad_problem {
    public static void printKeypad(String digit, String ans, String map[], int index){
        if(index >= digit.length()){
            System.out.println(ans);
            return;
        }
        int number = digit.charAt(index) - '0';
        String value = map[number];

        for(int i =0; i< value.length(); i++){
            printKeypad(digit, ans+value.charAt(i), map, index+1);
        }
    }
    public static void main(String args[]){
        String map[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String digit = "23";

        printKeypad(digit, "", map, 0);
    }
}
