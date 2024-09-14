import java.util.*;
public class KrushKalAlgorithm {

    public static void createGraph(ArrayList<EdgeInfo>garph){
        garph.add(new EdgeInfo(0, 10, 1));
        garph.add(new EdgeInfo(0, 15, 2));
        garph.add(new EdgeInfo(0, 30, 3));
        garph.add(new EdgeInfo(1, 40, 3));
        garph.add(new EdgeInfo(2, 50, 3));
    }
    
    public static void main(String args[]){

        ArrayList<EdgeInfo>graph = new ArrayList<>();
        createGraph(graph);

        KrushKalAlgorithmImplentation minimumCost = new KrushKalAlgorithmImplentation(6);
        System.out.println(minimumCost.krushkalAlgorithmToFindMinumumCost(graph, 0));

    }
}
class EdgeInfo implements Comparable<EdgeInfo>{
    int src;
    int destination;
    int cost;

    EdgeInfo(int src, int cost, int destination){
        this.src = src;
        this.cost = cost;
        this.destination = destination;
    }

    @Override
    public int compareTo(EdgeInfo info){
        return this.cost - info.cost;
    }
}
class KrushKalAlgorithmImplentation{

    int partentLenght;
    int parent[];
    int rank[];

    KrushKalAlgorithmImplentation(int partentLenght){
        this.partentLenght = partentLenght;
        this.parent = new int[partentLenght];
        this.rank = new int[partentLenght];
        init();
    }

    private void init(){
        for(int i=0; i<partentLenght; i++){
            parent[i] = i;
        }
    }

    public int krushkalAlgorithmToFindMinumumCost(ArrayList<EdgeInfo>garph, int src){

        PriorityQueue<EdgeInfo> pq = new PriorityQueue<>();

        pq.add(garph.get(src));
        int total_cost = 0;
        while (!pq.isEmpty()) {
            EdgeInfo curr = pq.remove();

            int a = curr.src;
            int b = curr.destination;

            // first we need to find their parent of and b
            int parentA = find(a);
            int parentB = find(b);

            if(parentA != parentB){
                union(a, b);
                total_cost+=curr.cost;
                pq.add(garph.get(b));

            }



        }
        return total_cost;
    }
    public void union(int a, int b){

        // here we need to find out their parent
        int parentA = find(a);
        int parentB = find(b);

        // case 1 rank of parent a equal to rank of parent b
        if(rank[parentA] == rank[parentB]){

            parent[parentB] = parentA;
            rank[parentA]++;
        }

        // case2 rank of parent a is greater thank rank of parent b
        else if(rank[parentA] > rank[parentB]){
            parent[parentB] = parentA;
        }
        // case rank of parent a is less than rank of parent b
        else{
            parent[parentA] = parentB;
        }
    }


    public int find(int x){

        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
