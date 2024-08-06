import java.util.Scanner;

public class character_pattern {
    public static void main(String args[]){
        System.out.println("Enter Number of Rows");
        Scanner sc = new Scanner(System.in);
        int number_of_rows = sc.nextInt();

        int rows = 0;
        int ascii_char = 65;
        while(rows < number_of_rows){
            int col = 0;
            while(col<= rows){
                char ch = (char) ascii_char;
                System.out.print(ch);
                ascii_char++;
                col++;
            }
            System.out.println();
            rows++;
        }
    }
}
