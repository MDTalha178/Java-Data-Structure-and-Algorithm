import java.util.LinkedList;
import java.util.PriorityQueue;
public class Merge_KSortedLinkedList {

    public static void mergeKsortedLinkedList(LinkedList<Integer>l1, LinkedList<Integer>l2, LinkedList<Integer>l3, LinkedList<Integer>ans){
        
        // define PQ to add data in PQ
        PriorityQueue<Integer>pq = new PriorityQueue<>();

        // Step 2 -> add all linked list data in PQ
        for(int i=0; i<l1.size(); i++){
            pq.add(l1.get(i));
            pq.add(l2.get(i));
            pq.add(l3.get(i));
        }

        // here we will add all data in PQ
        while (pq.size() > 0) {
            ans.addLast(pq.remove());
        }
    }
    public static void main(String args[]){
        LinkedList<Integer>l1 = new LinkedList<>();
        LinkedList<Integer>l2 = new LinkedList<>();
        LinkedList<Integer>l3 = new LinkedList<>();
        LinkedList<Integer>ans = new LinkedList<>();

        // here we will data for linked list1
        int arr1[] = {1,3,7};
        for(int i =0; i<arr1.length; i++){
            l1.addLast(arr1[i]);
        }
        // here we will add list2
        int arr2[] = {2,4,8};
        for(int i =0; i<arr2.length; i++){
            l2.addLast(arr2[i]);
    }

        // here we will add data for l3
        int arr3[] = {9,10,11};

        for(int i=0; i<arr3.length; i++){
            l3.addLast(arr3[i]);
        }

        // here we will merge our linked list
        mergeKsortedLinkedList(l1,l2,l3, ans);

        System.out.println(ans);
    }
}
