import java.util.*;
public class CountOFSubArrayEqualToK {

    public static int getCountOfsubarary(int arr[], int k){

        HashMap<Integer, Integer>sumAndCount = new HashMap<>();
        sumAndCount.put(0, 1);
        int sum = 0;
        int ans = 0;

        for(int i =0; i<arr.length; i++){

            sum += arr[i];

            int required_sum = sum - k;

            if(sumAndCount.containsKey(required_sum)){
               ans += sumAndCount.get(required_sum);
            }
            sumAndCount.put(sum, sumAndCount.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
    public static void main(String args[]){

        int arr[] = {10,2,-2,-20,10};
        int k = -10;

        int count = getCountOfsubarary(arr, k);

        System.out.println(count);
    }
}
