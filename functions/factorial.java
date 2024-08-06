import java.util.Scanner;

public class factorial {
    public static void printfactorial(int a){
        int fact = 1;
        for(int i = 1; i<=a; i++){
            fact *= i;
        }
        System.out.println("Your factorial number is: " + fact);
    }
    public static void main(String args[]){
        System.out.println("Enter your number to find a factorial!");

        Scanner sc = new Scanner(System.in);
        int factorial_number = sc.nextInt();

        if(factorial_number <= 0){
            System.out.println("Number Should be greater than 0");
        }
        else{
            printfactorial(factorial_number);
        }
    }
}
