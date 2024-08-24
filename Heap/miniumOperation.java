import java.util.*;
public class miniumOperation {

    public static int getMinimumTotalOperation(int arr[]){
        
        PriorityQueue<Integer>pq = new PriorityQueue<>(Comparator.reverseOrder());
        int initial_sum = 0;
        int max_element = 0;

        // Step 1-> we will add all element int PQ
        for(int i =0; i<arr.length; i++){
            pq.add(arr[i]);
            initial_sum += arr[i];
            if(max_element < arr[i]){
                max_element = arr[i];
            }
        }

        // step 2-> find half and number of peration
        int opeartion = 0;
        int half_sum = initial_sum / 2;

        while (initial_sum >= half_sum) {
            opeartion++;
            int top = pq.remove()/2;
            pq.add(top);

            initial_sum = initial_sum - top;
            if(initial_sum <= half_sum){
                break;
            }

        }
        return opeartion;


    }
    public static void main(String args[]){
        int arr[] = {1,5,8,19};

        int total_operation = getMinimumTotalOperation(arr);
        System.out.println(total_operation);
    }
}
