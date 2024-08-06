import java.util.Scanner;

public class count_vowels {
    public static int count_vowels(String str){
        int vowels_counts = 0;
        for(int i =0; i< str.length(); i++){
            char cur_char = Character.toLowerCase(str.charAt(i));
            if(cur_char =='a' || cur_char =='e' || cur_char =='i' || cur_char =='o' || cur_char=='u'){
                vowels_counts++;
            }
        }
        return vowels_counts;
    }
    public static void main(String args[]){
        StringBuilder sb = new StringBuilder();

        System.out.println("Please Enter strings");
        Scanner sc = new Scanner(System.in);
        sb.append(sc.nextLine());

        int vowels_counts = count_vowels(sb.toString());
        System.out.println(vowels_counts);
    }
}
