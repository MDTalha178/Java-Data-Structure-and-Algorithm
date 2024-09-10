import java.util.*;;
public class BellmanFordAlgorithm {

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
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 4, 2));

        // // here we will add 1 vertex
        graph[1].add(new Edge(1, -4, 2));

        // here we will add 2 vertex
        graph[2].add(new Edge(2, 2, 3));

        // // here we will add 3 vertex
        graph[3].add(new Edge(3, 4, 4));
        
        graph[4].add(new Edge(4, -1, 1));

        // graph[5].add(new Edge(5, 1, 0));
        // graph[5].add(new Edge(5, 1, 2));
        
    }

    public static void main(String args[]){
        int vertex = 5;
        ArrayList<Edge>graph[] = new ArrayList[vertex];
        createGraph(graph, vertex);

        AlgorithmImplementationBellman bellman = new AlgorithmImplementationBellman();
        bellman.bellmanFordAlgorithm(graph, 0);

    }
}

class AlgorithmImplementationBellman{

    public void bellmanFordAlgorithm(ArrayList<Edge>graph[], int src){

        int distance[] = new int[graph.length];

        for(int i =0; i<graph.length; i++){
            if(src != i){
                distance[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;
        for(int i =0; i<V-1; i++){
            for(int j=0; j<graph.length; j++){
                for(int k=0; k<graph[j].size(); k++){
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.destination;
                    int w = e.weight;

                    // relaxation
                    if(distance[u] != Integer.MAX_VALUE && distance[u]+w < distance[v]){
                        distance[v] = distance[u]+w;
                    }
                }
            }
        }
        for(int i=0; i<distance.length; i++){
            System.out.print(distance[i] + " ");
        }
    }
}
