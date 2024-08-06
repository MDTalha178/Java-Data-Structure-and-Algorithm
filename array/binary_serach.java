import java.util.Scanner;

public class binary_serach {

    public static int binary_serach(int arr[], int find_ele){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(arr[mid] == find_ele){
                return mid;
            }
            else if(arr[mid] < find_ele){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int array[] = {1,2,3,4,5,6,7,8};

        System.out.println("Enter your find index of that element");
        Scanner sc = new Scanner(System.in);
        int find_ele = sc.nextInt();

        int index = binary_serach(array, find_ele);
        System.out.println("Your element is present at: " + index);

    }
}
