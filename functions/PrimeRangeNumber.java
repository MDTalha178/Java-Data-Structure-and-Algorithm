import java.util.Scanner;


public class PrimeRangeNumber{

    public static boolean IsPrime(int number){
        boolean is_prime = true;
        for(int i = 2; i<number; i++){
            if(number % i == 0){
                return false;
            }
        }
        return is_prime;
    }

    public static boolean checkNumberIsValid(int number){
        boolean is_valid = true;
        if(number < 0){
            return false;
        }
        return is_valid;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your number range to get all prime number ");
        int a = sc.nextInt();
        if(checkNumberIsValid(a)){
            for(int i = 2; i< a - 2; i++){
                if(IsPrime(i)){
                    System.out.println("Prime Number is " + i);
                }
            }
        }else{
            System.out.println("Please enter valid number: note number shoulb be greater than 0");
        }


    }
}