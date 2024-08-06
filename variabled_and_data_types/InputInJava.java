import java.util.*;

public class InputInJava{
    public static void main(String args[]){
        System.out.println("Code Execution Started!");

        // taking input without space
        Scanner sc = new Scanner(System.in);
        String user = sc.next();
        System.out.println("Your Name is:" + user);

        // taking input with space as Stirng
        String name = sc.nextLine();
        System.out.println("Second Name is:" + name);

        // taking input with space as Integer
        int a = sc.nextInt();
        System.out.println("Your Integer input is:" + a);

        //  taking input with space as float
        float c = sc.nextFloat();
        System.out.println("float Number is" + c);

         //  taking input with space as double
        double d = sc.nextDouble();
        System.out.println(d);
    }
}