import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightKthStop {

    public static void createGraph(int flights[][], ArrayList<Edge>graph[]){

        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i =0; i<flights.length; i++){

            int src = flights[i][0];
            int des = flights[i][1];
            int wt = flights[i][2];

            graph[src].add(new Edge(src, wt, des));
        }

    }

    public static void findCheapestFlight(int fligths[][], ArrayList<Edge>graph[], int src, int destination, int k){

        Queue<Info>q = new LinkedList<>();
        int ditsance[] = new int[graph.length];
        for(int i=0; i< graph.length; i++){
            if(i!=src){
                ditsance[i] = Integer.MAX_VALUE;
            }
        }
        System.out.println("Called");
        q.add(new Info(src, 0,0));
        while (!q.isEmpty()) {
            Info curr = q.remove();

            if(curr.stops > k){
                break;
            }
            for(int i=0; i<graph[curr.node].size(); i++){
                Edge e =  graph[curr.node].get(i);
                int u = e.src;
                int v = e.destination;
                int w = e.weight;

                if(ditsance[u] != Integer.MAX_VALUE && curr.cost+w < ditsance[v] && curr.stops <=k){
                    ditsance[v] = curr.cost+w;
                    System.out.print("Innde");
                    q.add(new Info(v, curr.stops+1, ditsance[v]));
                }
            }
        }
        System.out.println("Tes" + ditsance[destination]);

    }
    
    public static void main(String args[]){
        System.out.println("STrted");
        int arr[][] = {{0,1,100}, {1,2,100},{2,0,100}, {1,3,600}, {2,3,200}};
        ArrayList<Edge>graph[] = new ArrayList[4];
        createGraph(arr, graph);
        int source = 0;
        int desction =3;
        int k = 1;
        findCheapestFlight(arr, graph, source, desction, k);
    }
}

class Info{

    int node;
    int cost;
    int stops;

    Info(int node, int stops, int cost){
        this.node = node;
        this.cost = cost;
        this.stops = stops;
    }
}
