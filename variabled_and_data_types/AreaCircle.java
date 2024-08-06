import java.util.*;

public class AreaCircle{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your radus");
        int radius = sc.nextInt();
        float area = 3.14f * radius * radius;
        System.out.println("Area of circle is: " + area);
    }
}