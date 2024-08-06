import java.util.Scanner;

public class star_pattern {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int number_of_rows = sc.nextInt();

        int rows = 0;

        while(rows < number_of_rows){
            int col = 0;
            while(col <= rows){
                System.out.print("* ");
                col++;
            }
            System.out.println();
            rows++;
        }
    }
}
