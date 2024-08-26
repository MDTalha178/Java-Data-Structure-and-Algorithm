import java.util.*;;
public class frequencyNby3 {
    public static void main(String args[]){
        int arr[] = {1,3,2,3,1,3,1,3,1};
        HashMap<Integer, Integer>hashMap = new HashMap<>();

        for(int i =0; i<arr.length; i++){
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        for(Integer key : hashMap.keySet()){
            if(hashMap.get(key) > arr.length / 3){
                System.out.println(key);
            }
        }
    }
}
