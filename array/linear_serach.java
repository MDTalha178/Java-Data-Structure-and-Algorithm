import java.util.Scanner;

public class linear_serach {

    // find element in an array
    public static boolean linear_serach(int array[], int search_number){
        boolean is_present = false;
        for(int i =0; i< array.length; i++){
            if(array[i] == search_number){
                return true;
            }
        }
        return is_present;
    }
    public static void printArray(int array[]){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
    public static void main(String args[]){
        int array[] = {3,2,1,4,5,6,71,10};

        System.out.println("Your Given Arrays is");
        printArray(array);

        // taking input from user to find element in arary
        System.out.println("Enter a number to check is present in an array or not!");
        Scanner sc = new Scanner(System.in);
        int find_ele = sc.nextInt();

        boolean isPresent = linear_serach(array, find_ele);
        if(isPresent){
            System.out.println("Yes" + " " +  find_ele + " is present in an Array" );
        }
        else{
            System.out.println("No" + " "  + find_ele + " is not present in an Array" );
        }
    }
}
