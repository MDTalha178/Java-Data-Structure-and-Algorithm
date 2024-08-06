import java.util.Scanner;

/**
 * print_n_natural_number
 */
public class print_n_natural_number {

    public static void print_n_natural_number(int n){
        if(n == 1){
            System.out.println(1);
            return;
        }
        print_n_natural_number(n-1);
        System.out.println(n);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        print_n_natural_number(number);
    }
}