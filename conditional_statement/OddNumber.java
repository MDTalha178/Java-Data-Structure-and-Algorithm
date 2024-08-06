import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class OddNumber{
    public static void main(String args[]){
        System.out.print("Enter your Number to check is odd..? ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        if(number % 2 == 0){
            System.out.println("This numbet is not odd");
        }
        else{
            System.out.println("Given number is Odd");
        }
    }
}