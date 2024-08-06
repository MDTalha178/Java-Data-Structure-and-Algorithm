import java.util.Scanner;

public class TaxCalculator{
    public static void main(String args[]){
        System.out.println("Welcome to tax calculator!");
        System.out.print("Please Enter your income! ");

        Scanner sc = new Scanner(System.in);
        int income = sc.nextInt();
        int tax = 0;
        if (income <= 500000){
            System.out.println("Yeah! your are not elible for tax!");
        }
        else if(income > 500000 && income <= 100000){
            tax = income * 20 / 100;
            System.out.println("Your tax amount is "+ tax);
        }
        else{
            tax = income * 30 / 100;
            System.out.println("Your tax amount is "+ tax);
        }
    }
}