import java.util.Scanner;

public class convert_uppercase {

    public static String convert_uppercase(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i =1; i< str.length(); i++){
            if(str.charAt(i) == ' ' && i < str.length() -1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String args[]){
        StringBuilder sb = new StringBuilder();

        System.out.println("Please enter your sentence!");
        Scanner sc = new Scanner(System.in);
        sb.append(sc.nextLine());

        String converted_string = convert_uppercase(sb.toString());
        System.out.println(converted_string);

    }
}
