import java.util.Scanner;

public class ternarory {

    public static void main(String args[]){
        System.out.println("Please Eneter number  to Check Type is even or odd");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        String number_type =  number % 2 == 0 ? "its Even" : "Its Odd";
        System.out.println("Your Number type is: " + number_type);

        System.out.println("Want to check our pass and fail services..?");
        boolean pass_services = sc.nextBoolean();
        if(pass_services){
            System.out.println("Enter your marks!");
            int marks = sc.nextInt();
            String results = marks >= 33? "Yeah.. you are Pass" : "Oops You are fail...better luck next time";
            System.out.println("Your Result is here " + results);
        }
        else{
            System.out.println("Thanks for using our services! ");
        }

    }
}