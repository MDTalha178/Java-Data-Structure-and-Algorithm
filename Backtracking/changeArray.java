public class changeArray {
    public static void printArray(int arr[]){
        for(int i =0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void change_array(int arr[],int i, int n){
        if(i == n){
            return;
        }
        change_array(arr, i+1, n);
        arr[i] = arr[i] - 2;
    }
    public static void main(String args[]){

        int arr[] = {1,2,3,4,5};
        System.out.println("------Before Backtracking-----");
        printArray(arr);
        System.out.println("------After Backtracking-----");
        change_array(arr,0,  arr.length-1);
        printArray(arr);
    }
}
