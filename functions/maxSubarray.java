public class maxSubarray {

    public static int maxiumSubArraySum(int arr[]){
        int max_mum_sum = Integer.MIN_VALUE;
        for(int i =0; i<arr.length; i++){
            for(int j = i; j<arr.length; j++){
                int curr_sum = 0;
                for(int k = i; k <= j; k++){
                    curr_sum += arr[k];
                }
                if(curr_sum > max_mum_sum){
                    max_mum_sum = curr_sum;
                }
            }
        }
        return max_mum_sum;
    }

    public static int optimizeSubArraySum(int arr[]){
        int max_sum = Integer.MIN_VALUE;
        
        // here we will calculate prefix
        int prefix_sum[] = new int[arr.length];
        prefix_sum[0] = arr[0];
        for(int i =1; i<arr.length; i++){
            prefix_sum[i] = prefix_sum[i] + arr[i];
        }

        // here we are calculating sum of sub array
        for(int i = 0; i< arr.length; i++){
            for(int j =i; j<arr.length; j++){
                int curr_sum = i == 0 ? prefix_sum[j] :prefix_sum[j] - prefix_sum[i-1];
                if(curr_sum > max_sum){
                    max_sum = curr_sum;
                }
            }
        }
        return max_sum;
    }
    public static void main(String args[]){
        int arr[] = {1, -2, 6, -1, 3};
        System.out.println("We are calculating maxium subarray!please wait...");
        int max_sub_arr_sum = maxiumSubArraySum(arr);
        System.out.println("The wait is over your maximum subarray is..." + max_sub_arr_sum);
        int opt_max_sub_array = optimizeSubArraySum(arr);
        System.out.println(opt_max_sub_array);

    }
}
