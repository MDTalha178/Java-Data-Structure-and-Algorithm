import java.util.*;
public class LargerTwoNumber{
    public static void main(String args[]){
        System.out.println("Enter your first number:");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("Enter your second number:");
        int b = sc.nextInt();

        if(a >b){
            System.out.println("A is greater than b");
        }
        else{
            System.out.println("B is greater than B");
        }
    }
}