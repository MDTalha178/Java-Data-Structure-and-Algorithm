import java.util.Scanner;

public class half_pyramid_pattern {
    public static void main(String args[]){
        System.out.println("Enter number of rows");
        Scanner sc = new Scanner(System.in);
        int number_of_rows = sc.nextInt();

        int rows = 1;
        while(rows <= number_of_rows){
            int col = 1;
            while(col <= rows){
                System.out.print(col);
                col++;
            }
            System.out.println();
            rows++;
        }
    }
}
