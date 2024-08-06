public class max_sum_kadane {

    public static int maxiumSubArraySumkadane(int arr[]){
        int max_sum = Integer.MIN_VALUE;
        int current_sum = 0;

        for(int i = 0; i<arr.length; i++){
            current_sum = arr[i] + current_sum;
            if(current_sum < 0){
                current_sum = 0;
            }
            else{
                max_sum = Math.max(max_sum, current_sum);
            }
        }
        return max_sum;
    }
    public static void main(String args[]){
        int arr[] = {1, -2, 6, -1, 3};
        System.out.println("We are calculating maxium subarray!please wait...");
        int max_sub_arr_sum = maxiumSubArraySumkadane(arr);
        System.out.println("The wait is over your maximum subarray is..." + max_sub_arr_sum);
    }
}
