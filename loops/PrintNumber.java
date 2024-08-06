import java.util.*;;

public class PrintNumber{
    public static void main(String arga[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number!");
        int number = sc.nextInt();
        int count = 1;
        while(count <= number){
            System.out.println(count++);
        }
    }
}