import java.util.*;;
public class hasPath {

    /**
     * This function will create a graph given the number of vertices
     * The graph created is a directed graph. The graph is represented
     * as an adjacency list.
     * @param graph the adjacency list of the graph
     * @param vertex the number of vertices in the graph
     */


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
    public static void createGraph(ArrayList<Edge>graph[], int vertex){
        // initalize array 
       for(int i=0; i<vertex; i++){
           graph[i] = new ArrayList<>();
       }

       // Here we will add 0 vertex
       graph[0].add(new Edge(0, 1, 1));
       graph[0].add(new Edge(0, 1, 2));

       // here we will add 1 vertex
       graph[1].add(new Edge(1, 1, 3));
       graph[1].add(new Edge(1, 1, 2));
       graph[1].add(new Edge(1, 1, 0));

       // here we will add 2 vertex
       graph[2].add(new Edge(2, 1, 0));
       graph[2].add(new Edge(2, 1, 1));
       graph[2].add(new Edge(2, 1, 4));

       // here we will add 3 vertex
       graph[3].add(new Edge(3, 1, 1));
       graph[3].add(new Edge(3, 1, 5));

       // here we will add 4 vertex
       graph[4].add(new Edge(4, 1, 2));
       graph[4].add(new Edge(4, 1, 5));

       // here we will add 5 vertex
       graph[5].add(new Edge(5, 1, 3));
       graph[5].add(new Edge(5, 1, 4));
       graph[5].add(new Edge(5, 1, 6));

        // here we will add 5 vertex
       graph[6].add(new Edge(6, 1, 3));
       graph[6].add(new Edge(6, 1, 4));
   }


    /**
     * This function will tell us that whether a path exists from
     * given source to destination or not.
     * 
     * @param graph is our adjacency list of graph
     * @param visited is a boolean array that will tell that
     *                 whether a particular node is visited or not
     * @param cur is the current node
     * @param path is the destination node
     * @return true if path exists otherwise false
     */

    public static boolean hasPathforEdge(ArrayList<Edge>graph[], boolean visited[], int cur, int path){

        if(cur == path){
            return true;
        }
        visited[cur] = true;
        for(int i =0; i<graph[cur].size(); i++){

            Edge e = graph[cur].get(i);
            if(!visited[e.destination] && hasPathforEdge(graph, visited, e.destination, path)){
                return true;
            }
        }
        return false;
    }
    

        /**
         * This is the main function which will test our
         * hasPathforEdge function.
         * 
         * @param args is the command line arguments
         */

    public static void main(String args[]){

        int vertex = 8;
        ArrayList<Edge>graph[] = new ArrayList[vertex];

        // here we will create our graph
        createGraph(graph, vertex);

        boolean visited[] = new boolean[graph.length];

        if(hasPathforEdge(graph, visited, 0, 6)){
            System.out.println("Path exits");
        }else{
            System.out.println("Path not exists");
        }
        
        
    }
}

/**
 * This class will represent the edge of the graph.
 * It will have the source of the edge, the weight of the edge and the destination of the edge.
 * 
 * @author Bhavyai Gupta
 *
 */
class Edge{

    int src;
    int weight;
    int destination;

    Edge(int src, int weight, int destination){
        this.src = src;
        this.weight = weight;
        this.destination = destination;
    }
}