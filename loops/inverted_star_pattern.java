import java.util.Scanner;

public class inverted_star_pattern {
    public static void main(String args[]){
        System.out.println("Enter number of rows");
        Scanner sc = new Scanner(System.in);

        int number_of_rows = sc.nextInt();
        int rows = 0;

        while(rows < number_of_rows){
            int number_of_col = number_of_rows - rows;
            int col = 0;
            while(col < number_of_col){
                System.out.print("* ");
                col++;
            }
            System.out.println();
            rows++;
        }
    }
}
