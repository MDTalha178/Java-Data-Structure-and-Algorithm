import java.util.*;
public class Sliding_Window {
    public static void main(String args[]){
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int result[] = new int[arr.length - k +1];
        PriorityQueue<MaximumInfo>pq = new PriorityQueue<>();

        // Step 1-> insert 1 to kth element in Priority Queue
        for(int i =0; i<k; i++){
            pq.add(new MaximumInfo(i, arr[i]));
        }

        // Step 2-> add first element int result
        result[0] = pq.peek().value;

        // step3 -> get answer for rest of the arr
        for(int i =k; i< arr.length; i++){

            // step1-> we  need to check pq index is still in range
            while(pq.size() > 0 && pq.peek().index <= i-k){
                pq.remove();
            }  
            
            // Step 2-> add current element in our PQ
            pq.add(new MaximumInfo(i, arr[i]));

            // add top element of pq in result
            result[i-k+1] = pq.peek().value;
        }

        // here we will print
        for(int j=0; j<result.length; j++){
            System.out.print(result[j] + " ");
        }


    }
}

class MaximumInfo implements Comparable<MaximumInfo>{

    int index;
    int value;

    public MaximumInfo(int index, int value){
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(MaximumInfo info){
        return info.value - this.value;
    }
}
