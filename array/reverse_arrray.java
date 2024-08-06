public class reverse_arrray {

    // reverse an array
    public static void reverse_arrray(int arr[]){
        int start = 0;
        int end = arr.length -1;

        while (start <=  end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start ++;
            end--;
        }
    }

    // print an Array
    public static void printArray(int arr[]){
        for(int i =0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6};

        System.out.println("We are reversing your array please wait...");
        reverse_arrray(arr);
        printArray(arr);
    }
}
