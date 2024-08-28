import java.util.*;;
public class SumofTwoNumberequalk {

    public static void getsumOfTwoNumber(int arr[], int target){

        HashMap<Integer, Integer>sumAnsIndex = new HashMap<>();
        for(int i =0; i<arr.length; i++){
            int required_sum =  target - arr[i] ;

            if(sumAnsIndex.containsKey(required_sum)){
                System.out.println("(" + sumAnsIndex.get(required_sum) + ',' + i + ")");
            }
            sumAnsIndex.put(arr[i], i);

        }
    }
    public static void main(String args[]){
        int arr[] = {3,2,4};
        int target = 6;
        getsumOfTwoNumber(arr, target);
    }
}
