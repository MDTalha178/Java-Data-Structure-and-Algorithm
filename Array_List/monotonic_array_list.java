import java.util.ArrayList;
import java.util.Scanner;
public class monotonic_array_list {
    public static boolean check_sorted_in_incr(ArrayList<Integer>arr){
        boolean is_sorted = true;
        for(int i=0; i<arr.size()-1; i++){
            if(arr.get(i) > arr.get(i+1)){
                is_sorted = false;
                break;
            }
        }
        return is_sorted;
    }
    public static boolean check_sorted_in_desc(ArrayList<Integer>arr){
        boolean is_sorted = true;
        for(int i=0; i<arr.size()-1; i++){
            if(arr.get(i) < arr.get(i+1)){
                is_sorted = false;
                break;
            }
        }
        return is_sorted;
    }
    public static boolean is_array_monotonic(ArrayList<Integer>arr){
        boolean is_sorted = check_sorted_in_incr(arr);
        if(!is_sorted){
            is_sorted = check_sorted_in_desc(arr);
        }
        return is_sorted;
    }
    public static void main(String arga[]){
        ArrayList<Integer>list = new ArrayList<>();

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Length of your array");
        int length_of_array = sc.nextInt();

        for(int i=0; i<length_of_array; i++){
            int cur = sc.nextInt();
            list.add(cur);
        }

        boolean check = is_array_monotonic(list);
        if(check){
            System.out.println("Your Array is Monolotic");
        }else{
            System.out.println("Your Array is not Monolotic");
        }
    }
}
