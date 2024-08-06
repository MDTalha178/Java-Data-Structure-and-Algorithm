import java.util.Queue;
import java.util.LinkedList;
public class Interleave_2half {
    // here we will reverse array from mid
    public static void reverseArrayFrommid(int arr[], int mid){
        int start = mid;
        int end = arr.length - 1;
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void interleave_2half(int arr[]){
        Queue<Integer>queue = new LinkedList<>();
        int mid = arr.length / 2;
        System.out.println(mid);

        // here we will reverse from mid
        reverseArrayFrommid(arr, mid);

        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            queue.add(arr[start]);
            queue.add(arr[end]);
            start++;
            end--;
        }

        // here we will copy all element
        for(int i =0; i<arr.length; i++){
            arr[i] = queue.remove();
        }
    }

    // print array
    public static void printArray(int arr[]){
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]){
        int arr[]=  {1,2,3,4,5,6,7,8};
        interleave_2half(arr);

        // here we will print our array
        printArray(arr);


    }
}
