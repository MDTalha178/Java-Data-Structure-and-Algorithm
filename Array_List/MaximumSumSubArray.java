public class MaximumSumSubArray {
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6};
        int maxSum = -1;
        for(int i =0; i<arr.length; i++){
            for(int j= i+1; j<arr.length; j++){
                int curr =0;
                for(int k=i; k<=j; k++){
                    curr += arr[k];
                    maxSum = Math.max(maxSum, curr);
                }
                
            }
        }
        System.out.print(maxSum);

        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];

        for(int i =1; i<arr.length; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        // optimize opproach
        for(int i =0; i<arr.length; i++){
            int cur_sum = 0;
            for(int j =i; j<arr.length; j++){

                if(i == 0){
                    cur_sum = prefix[i];
                }else{
                    cur_sum = prefix[j] - prefix[i-1];

                }
                maxSum = Math.max(maxSum, cur_sum);
            }
        }
        System.out.println(maxSum);
    }
}
