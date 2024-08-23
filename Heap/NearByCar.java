import java.util.*;
public class NearByCar {
    public static void main(String[] args) {
    int arr[][] = {{3,3},{5,-1},{-2,-4}};
    int k = 2;

    PriorityQueue<Info>pq = new PriorityQueue<>();

    for(int i=0; i<arr.length; i++){
        int dist = arr[i][0] * arr[i][0] + arr[i][1] * arr[i][1];
        pq.add(new Info(arr[i][0], arr[i][1], dist));
    }

    // shortest k path
    for(int i=0; i<k; i++){
        Info s = pq.remove();
        System.out.println("(" + s.x +"X" + ',' + s.y + "y)" + "Distance " + s.dist);
    }
}


}

class Info implements Comparable<Info>{

    int x;
    int y;
    int dist;

    public Info(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(Info info){
        return this.dist - info.dist;
    }
}