import java.util.Scanner;

public class reverse_number {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int reverse_number = 0;
        while(number > 0){
            int last_digit = number % 10;
            reverse_number = (reverse_number * 10) + last_digit;
            number =  number / 10;
        }
        System.out.println("Reverse number is " + reverse_number);
    }
}
