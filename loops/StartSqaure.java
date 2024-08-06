import java.util.Scanner;

public class StartSqaure{
    public static void main(String args[]){
        System.out.println("Enter number of rows:");
        Scanner sc = new Scanner(System.in);
        int number_of_rows = sc.nextInt();
        System.out.println("Enter number of column");
        int number_of_col = sc.nextInt();

        int row = 0;

        while(row < number_of_rows){
            int col = 0;
            while(col < number_of_col){
                System.out.print("* ");
                col++;
            }
            System.out.println();
            row++;
        }
    }
}