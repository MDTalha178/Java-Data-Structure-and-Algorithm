import java.util.*;;
public class DijkstrasAlgorithm {

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

        // Here we will add 0 vertex
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 4, 2));

        // here we will add 1 vertex
        graph[1].add(new Edge(1, 1, 2));
        graph[1].add(new Edge(1, 7, 3));

        // here we will add 2 vertex
        graph[2].add(new Edge(2, 3, 4));

        // here we will add 3 vertex
        graph[3].add(new Edge(3, 1, 5));
        
        graph[4].add(new Edge(4, 2, 3));
        graph[4].add(new Edge(4, 3, 5));


        
    }
    
    public static void main(String args[]){
        int vertex = 6;
        ArrayList<Edge>graph[] = new ArrayList[vertex];

        createGraph(graph, vertex);

        AlgorithmImplementation  dijkstras = new AlgorithmImplementation();
        dijkstras.shortestPath(graph);
        
    }
}

class Pair implements Comparable<Pair>{

    int node;
    int path;

    Pair(int node, int path){
        this.node = node;
        this.path = path;
    }

    @Override
    public int compareTo(Pair pair){
        return this.path - pair.path;
    }
}

class AlgorithmImplementation{

    public  void shortestPath(ArrayList<Edge>graph[]){

        int distance[] = new int[graph.length];

        for(int i =0; i<distance.length; i++){
            if(i != 0){
                distance[i] = Integer.MAX_VALUE;
            }
        }

        boolean visited[] = new boolean[graph.length];

        PriorityQueue<Pair>pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        // here we will start BFS
        while (!pq.isEmpty()) {
            
            Pair curr = pq.remove();

            if(!visited[curr.node]){

                visited[curr.node] = true;
                for(int i =0; i<graph[curr.node].size(); i++){

                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.destination;
                    int weight = e.weight;

                    if(distance[u] + weight < distance[v]){
                        distance[v] = distance[u]+weight;
                        pq.add(new Pair(v, distance[v]));
                    }
                }
            }

        }
        for(int i=0; i<distance.length; i++){
            System.out.print(distance[i] + " ");
        }
    }
}
