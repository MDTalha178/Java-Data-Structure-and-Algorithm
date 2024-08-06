public class quick_sort {
    public static void swap(int i, int j, int arr[]){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int partition(int arr[], int start, int end){

        int pivot = arr[end];
        int i = start-1;
        for(int j=start; j< end; j++){
            if(arr[j] <= pivot){
                i++;
                swap(i, j, arr);
            }
        }
        i++;
        int temp = pivot;
        arr[end] = arr[i];
        arr[i] = temp;
        return i;

    }
    public static void quick_sort(int arr[], int start, int end){
        if(start >= end){
            return;
        }
        int pivotIndex = partition(arr, start, end);
        quick_sort(arr, start, pivotIndex-1);
        quick_sort(arr, pivotIndex+1, end);
    }

    public static void main(String args[]){

        int arr[] = {9,3,2,1,4,5};
        quick_sort(arr, 0, arr.length-1);

        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
