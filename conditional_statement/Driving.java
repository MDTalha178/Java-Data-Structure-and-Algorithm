import java.util.*;

public class Driving{
    public static void main(String args[]){
        System.out.print("Enter your age: ");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        if(age >= 18){
            System.out.println("Congrats! you are Eligible for Driving Liscense");
        }
        if (age < 18 && age >= 14){
            System.out.println("Oops! you are teen ager! please wait for ->" + (18-age) + "years");
        }
        else{
            System.out.println("You are too samll I think you have wait for long time");
        }

    }
}