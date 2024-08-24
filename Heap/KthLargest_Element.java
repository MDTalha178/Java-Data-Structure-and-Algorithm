import java.util.*;
public class KthLargest_Element {
    public static void getKthLargestElement(int arr[], int k, ArrayList<Integer>ans){
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++){
            pq.add(arr[i]);

            // here we will check size if pq kth is present in our pq or not
            if(pq.size() >= k){
                int cur = pq.remove();
                ans.add(cur);
            }else{
                ans.add(-1);
            }
        }
    }
    public static void main(String args[]){
        int arr[] = {10, 20, 11, 70, 50, 40, 100, 5};
        int k = 3;
        ArrayList<Integer>ans = new ArrayList<>();
        getKthLargestElement(arr, k, ans);

        System.out.println(ans);
    }
}
