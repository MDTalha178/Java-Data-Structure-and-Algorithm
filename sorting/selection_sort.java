public class selection_sort {
    public static void swap(int i, int j, int arr[]){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void selection_sort(int arr[]){
        for(int i  =0; i< arr.length; i++){
            int minPos =i;
            for(int j= i+1; j<arr.length; j++){
                if(arr[i] > arr[j]){
                    minPos = j;
                }
            }
            // here we swap 
            swap(i, minPos, arr);
        }
    }

    public static void printArray(int arr[]){
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String args[]){
        int arr[] = {9,3,2,1,9,0};

        selection_sort(arr);
        printArray(arr);
    }
}
