import java.util.Scanner;

public class rotate_array {

    public static void rotate_array(int arr[], int rotate_index){

        // here we store rotate element
        int helper_array[] = new int[arr.length]; 
        int curr_index = 0;
        for(int i = rotate_index; i< arr.length; i++){
            helper_array[curr_index++] = arr[i];
        }
        for(int i = 0; i<rotate_index; i++){
            helper_array[curr_index++] = arr[i];
        }
        for(int i=0; i< arr.length; i++){
            arr[i] = helper_array[i];
        }
    }

    public static void printArray(int arr[]){
        for(int i =0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter index number to rotate array");
        int rotate_index = sc.nextInt();

        rotate_array(arr, rotate_index);
        printArray(arr);

    }
}
