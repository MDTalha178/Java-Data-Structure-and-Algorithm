import java.util.Scanner;

import javax.swing.text.html.StyleSheet;

public class sum_of_n_number{
    public static void main(String args[]){
        System.out.print("Enter your number: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int counter = 0;
        int sum = 0;
        while(counter < number){
            sum  += counter;
            counter++;
        }
        System.out.println("Your Total sum is: " + sum);

    }
}