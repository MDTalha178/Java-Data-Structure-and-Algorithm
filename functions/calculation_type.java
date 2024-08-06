import java.util.Scanner;

public class calculation_type{
    // addition function
    public static int addition(int a, int b){
        return a + b;
    }
    // subtraction function
    public static int substract(int a, int b){
        return a - b;
    }
    // multiplication function
    public static int multiply(int a, int b){
        return a * b;
    }

    //divide function
    public static int divide(int a, int b){
        return a / b;
    }

    // print calculator options
    public static void print_calculator_option(){
        System.out.println("add");
        System.out.println("substract");
        System.out.println("multiply");
        System.out.println("divide");
    }
    public static void main(String args[]){
        System.out.println("Please Choose given to calculate: ");
        print_calculator_option();
        Scanner sc = new Scanner(System.in);
        String  calculation_type = sc.next();

        int a  = sc.nextInt();
        int b = sc.nextInt();

        if(calculation_type.equals("add")){
            // here we call add function
            int sum = addition(a, b);
            System.out.println("Your Addition of two number is " + sum);
        }
        else if (calculation_type.equals("substract")){
            //here we perform subtraction
            int subtraction = substract(a, b);
            System.out.println("Your Substraction of two number is " + subtraction);
        }
        else if(calculation_type.equals("multiply")){
            //here we perform multiply
            int multiplication = multiply(a, b);
            System.out.println("Your Multiplication of two number is " + multiplication);
        }
        else if(calculation_type.equals("divide")){
            // here we perform divide
            int divide = divide(a, b);
            System.out.println("Your Division of two number is " + divide);
        }
        else{
            System.out.println("Please choose correct option!");
        }

    }
}