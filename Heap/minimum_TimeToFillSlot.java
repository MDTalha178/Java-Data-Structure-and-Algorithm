import java.util.LinkedList;
import java.util.Queue;

public class minimum_TimeToFillSlot {
    public static int getMinimumTImeToFillSlot(int arr[], int n, int k){
        int time = 0;
        Queue<Integer>queue = new LinkedList<>();
        boolean visited[] = new boolean[n+1];

        for(int i =0; i<k; i++){
            queue.add(arr[i]);
            visited[arr[i]] = true;
        }

        while (!queue.isEmpty()) {
            for(int i=0; i<queue.size(); i++){
                int cur = queue.poll();
                System.out.println(cur + "curr");
                if(cur-1 >=1 && !visited[cur-1]){
                    queue.add(cur-1);
                    visited[cur-1] = true;
                }
                if(cur + 1 <= n && !visited[cur+1]){
                    queue.add(cur+1);
                    visited[cur+1] = true;
                }
            }
            System.out.println(queue.size() + "OUT");
            time++;
        }

        return time;
    }
    public static void main(String args[]){
        int arr[] = {2,6};
        int n = 6;
        int k = 2;
    
        int time = getMinimumTImeToFillSlot(arr, n, k);
        System.out.println(time-1);
    }
   
}
