public class insertion_java {
    public static void insertion_sort(int arr[]){
        for(int i = 1; i< arr.length; i++){
            int curr = arr[i];
            int prev = i-1;

            while(prev >=0 && arr[prev] > curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }
    public static void printArray(int arr[]){
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String args[]){
        int arr[] = {9,3,2,1,4,5};

        insertion_sort(arr);
        printArray(arr);
    }
}
