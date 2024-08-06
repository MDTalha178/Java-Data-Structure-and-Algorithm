import java.util.Scanner;

public class compressString {
    public static String compress_string(String str){
        StringBuilder sb = new StringBuilder();
        // sb.append(str.charAt(0));
        // sb.append(sb.charAt(1));
        // aaabb
        Integer current_count = 1;
        int i = 1;
        for(i = 1; i< str.length(); i++){
            if(str.charAt(i-1) == str.charAt(i)){
                current_count += 1;
            }else{
                sb.append(str.charAt(i-1));
                sb.append(current_count.toString());
                current_count = 1;
            }
        }
        sb.append(str.charAt(i-1));
        sb.append(current_count.toString());
        return sb.toString();
    }
    public static void main(String args[]){
        StringBuilder sb = new StringBuilder();

        System.out.println("Enter string to compress");
        Scanner sc = new Scanner(System.in);
        sb.append(sc.nextLine());

        String compress_str = compress_string(sb.toString());
        System.out.println(compress_str);
    }
}
