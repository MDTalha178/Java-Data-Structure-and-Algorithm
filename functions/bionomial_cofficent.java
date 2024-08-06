import java.util.Scanner;

public class bionomial_cofficent {
    
    // function to calculate factorial
    public static int get_factorial(int number){
        int fac = 1;
        for(int i = 1; i<=number; i++){
            fac*=i;
        }
        return fac;
    }
    public static void main(String args[]){
        System.out.println("Enter your number to find bionomial coffient");
        Scanner sc = new Scanner(System.in);

        int bionomial_cofficent = sc.nextInt();
        System.out.println("Enter your number to find bionomial combinaltion");
        int combination = sc.nextInt();
        if(bionomial_cofficent <= 0){
            System.out.println("Number should be greater than 0");
        }
        else{
            int n_factorial = get_factorial(bionomial_cofficent);
            int r_factorial = get_factorial(combination);
            int n_r_factorial = get_factorial(bionomial_cofficent-r_factorial);

            int bionomial = n_factorial / r_factorial * n_r_factorial;
            System.out.println("Your bionomial coffient is " + bionomial);
        }
    }
}
