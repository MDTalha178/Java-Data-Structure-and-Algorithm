public class check_array_is_sorted {
    public static boolean check_array_is_sorted(int arr[], int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return check_array_is_sorted(arr, i+1);
    }
    public static void main(String args[]){
        int arr[] = {1,2,9,4,5};
        boolean  is_sorted = check_array_is_sorted(arr, 0);
        System.out.println(is_sorted);
    }
}
