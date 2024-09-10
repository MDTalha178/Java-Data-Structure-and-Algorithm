import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimisAlgorithm {

     /**
     * This function will create a directed graph with 7 vertices.
     * The graph is represented as an adjacency list.
     * The graph is created as follows:
     *      0 --1--> 1
     *      0 --1--> 2
     *      1 --1--> 0
     *      1 --1--> 2
     *      1 --1--> 3
     *      2 --1--> 0
     *      2 --1--> 1
     *      2 --1--> 4
     *      3 --1--> 1
     *      3 --1--> 5
     *      4 --1--> 2
     *      4 --1--> 5
     *      5 --1--> 3
     *      5 --1--> 4
     *      5 --1--> 6
     *      6 --1--> 3
     *      6 --1--> 4
     */
    public static void createGraph(ArrayList<Edge>[] graph, int vertex){

        // here we will assign empty graph
        for(int i =0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // // Here we will add 0 vertex
        graph[0].add(new Edge(0, 10, 1));
        graph[0].add(new Edge(0, 15, 2));
        graph[0].add(new Edge(0, 30, 3));

        // // here we will add 1 vertex
        graph[1].add(new Edge(1, 10, 0));
        graph[1].add(new Edge(1, 40, 3));

        // here we will add 2 vertex
        graph[2].add(new Edge(2, 15, 0));
        graph[2].add(new Edge(2, 50, 3));

        // here we will add 3 vertex
        graph[3].add(new Edge(3,40, 1));
        graph[3].add(new Edge(3,50, 2));
        
        // graph[4].add(new Edge(4, 1, 0));
        // graph[4].add(new Edge(4, 1, 1));

        // graph[5].add(new Edge(5, 1, 0));
        // graph[5].add(new Edge(5, 1, 2));
        
    }
    public static void main(String args[]){

        int vertex = 4;
        ArrayList<Edge>graph[] = new ArrayList[vertex];

        createGraph(graph, vertex);

        AlgorithmImplementationPrism prims = new AlgorithmImplementationPrism();
        prims.prismAlgorithm(graph, 0);

    }
}

class PairPrism implements Comparable<PairPrism>{

    int vertex;
    int cost;

    PairPrism(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(PairPrism p2){
        return this.cost - p2.cost;
    }
}

class AlgorithmImplementationPrism{

    public void prismAlgorithm(ArrayList<Edge>graph[], int src){

        boolean  visited[] = new boolean[graph.length];

        PriorityQueue<PairPrism>pq = new PriorityQueue<>();

        pq.add(new PairPrism(src, 0));
        int total_cost = 0;

        // prism algorihtm
        while (!pq.isEmpty()) {
            PairPrism curr = pq.remove();

            if(!visited[curr.vertex]){

                visited[curr.vertex] = true;
                total_cost+=curr.cost;

                for(int i=0; i<graph[curr.vertex].size(); i++){
                    Edge e = graph[curr.vertex].get(i);
                    pq.add(new PairPrism(e.destination, e.weight));
                }
            }
        }
        System.out.println("Total cost for MST " + total_cost);
    }
}
