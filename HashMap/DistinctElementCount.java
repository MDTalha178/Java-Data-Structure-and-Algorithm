import java.util.*;;
public class DistinctElementCount {

    public static int getCountOfDistinct(int arr[]){

        int count_of_distinct_element = 0;

        // here we will create HashMap which store frequency
        HashMap<Integer, Integer>freq_map = new HashMap<>();

        // here we store frequency for every element in an array
        for(int i =0; i<arr.length; i++){
            freq_map.put(arr[i], freq_map.getOrDefault(arr[i], 0) + 1);
        }

        // here we will calulate a freq
        for(Integer key: freq_map.keySet()){

            // here we will check the frequency
            if(freq_map.get(key) == 1){
                count_of_distinct_element++;
            }
        }
        return count_of_distinct_element;



    }
    public static void main(String args[]){

        int arr[] = {4,3,2,5,6,7,3,4,2,1};

        int countOfDistinct = getCountOfDistinct(arr);

        System.out.println("Frequency of Distinct element "+ countOfDistinct);
    }
}
