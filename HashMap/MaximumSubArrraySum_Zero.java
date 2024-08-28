import java.util.*;
public class MaximumSubArrraySum_Zero {
    public static int getMaximumSubArrayZeroSum(int arr[]){

        HashMap<Integer, Integer> maximumSumWithIndex = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        for(int i =0; i<arr.length; i++){
            sum+= arr[i];

            if(maximumSumWithIndex.containsKey(sum)){
                int currLength = i - maximumSumWithIndex.get(sum);
                maxLength =  Math.max(maxLength, currLength);
            }
            else{
                maximumSumWithIndex.put(sum, i);
            }
        }
        return maxLength;
    }
    public static void main(String args[]){

        int arr[] = {15,-2,2,-8,1,7,10,23};

        int maximumLength = getMaximumSubArrayZeroSum(arr);

        System.out.println(maximumLength);


    }
}
