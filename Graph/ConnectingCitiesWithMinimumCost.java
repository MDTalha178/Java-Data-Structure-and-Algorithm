import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectingCitiesWithMinimumCost {

    public static void minimumCities(int cities[][], ArrayList<Edge>graph[], int src){

        boolean visited[] =  new boolean[graph.length];

        PriorityQueue<Infoi>pq = new PriorityQueue<>();
        pq.add(new Infoi(src, 0));

        int total_cost = 0;

        while (!pq.isEmpty()) {
            
            Infoi curr = pq.remove();
            if(!visited[curr.node]){

                visited[curr.node] = true;
                total_cost+=curr.cost;

                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e =  graph[curr.node].get(i);
                    pq.add(new Infoi(e.destination, e.weight));
                }
            }

        }
        System.out.println(total_cost);



    }
    public static void createGraph(int cities[][], ArrayList<Edge>graph[]){

        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<cities.length; i++){
            for(int j =0; j<cities[i].length; j++){
                graph[i].add(new Edge(i, cities[i][j], cities[i][j]));
            }
        }
    }
    
    public static void main(String args[]){

        int cities[][] = {{0,1,2,3,4}, {1,0,5,0,7},{2,5,0,6,0}, {3,0,6,0,0}, {4,7,0,0,0}};
        ArrayList<Edge>graph[] = new ArrayList[5];
        int src = 0;
        createGraph(cities, graph);
        minimumCities(cities, graph, src);
    }
}

class Infoi implements Comparable<Infoi>{

    int node;
    int cost;

    Infoi(int node, int cost){
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Infoi inf){
        return this.cost - inf.cost;
    }


}
