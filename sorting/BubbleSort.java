public class BubbleSort{

    public static void swap(int i, int j, int arr[]){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubble_sort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            for(int j = 0; j<arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    swap(j, j+1, arr);
                }
            }
        }
    }

    public static void printArray(int arr[]){
        for(int i =0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String args[]){
        int arr[] = {6,5,4,3,2,1};

        System.out.println("We are sorting your Array using Bubble Sort please wait..");
        bubble_sort(arr);
        printArray(arr);

    }
}