import java.util.*;
public class WeakSoldier {
    public static void main(String args[]){
        int arr[][] = {{1,0,0,0}, {1,1,1,1}, {1,0,0,0},{1,0,0,0}};

        PriorityQueue<SolderInfo>pq = new PriorityQueue<>();

        // here we will insert solder in Priority Queue
        for(int i =0; i<arr.length; i++){
            int count =0;
            for(int j =0; j<arr[0].length; j++){
                count+= arr[i][j] == 0 ? 1: 0;
            }
            pq.add(new SolderInfo(i, count));

        }

        // here we will print out weak solder
        for(int i=0; i<2; i++){
            SolderInfo info = pq.remove();
            System.out.println("Row" + info.row);
        }
        
        
    }
}

class SolderInfo implements Comparable<SolderInfo>{
    int row;
    int soldier_count;


    public SolderInfo(int row, int count){
        this.row = row;
        this.soldier_count = count;
    }

    @Override
    public int compareTo(SolderInfo info){
        if(this.soldier_count == info.soldier_count){
            return info.row - this.row;
        }else{
            return this.soldier_count - info.soldier_count;
        }
    }
}
