import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MultipleConnectedGraph {

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

    // here this function is used for utility
    public static void dfsConnectedComponentUtility(ArrayList<Edge>[] graph, int curr, boolean visited[]){

        // here we will first marked visited for current
        visited[curr] = true;

        System.out.print(curr + " ");

        for(int i =0; i<graph[curr].size(); i++){

            Edge e =  graph[curr].get(i);
            
            // here fisrt we checked its visited or not 
            if(!visited[e.destination]){
                dfsConnectedComponentUtility(graph, e.destination, visited);
            }
        }
    }


    /**
     * This function will perform a Depth First Search on a graph and print out each connected component.
     * The graph is represented as an adjacency list.
     * The DFS is performed by calling a utility function for each unvisited node.
     * @param graph the adjacency list of the graph
     * @param curr the current node
     */


    public static void dfsConnectedComponent(ArrayList<Edge>[] graph , int curr){

        boolean visited[] = new boolean[graph.length];

        // here we will marked false for visited graph
        for(int i=0; i<visited.length; i++){
            visited[i] = false;
        }
        // here we call DFS for every component
        for(int i =0; i<graph.length; i++){
            if(!visited[i]){
                dfsConnectedComponentUtility(graph, curr, visited);
            }   
        }
    }

    public static void bfsConnectedComponentUtility(ArrayList<Edge>[] graph, int curr, boolean visited[]){

        Queue<Integer>graphQueue = new LinkedList<>();
        graphQueue.add(curr);

        while (!graphQueue.isEmpty()) {
            
            int cur = graphQueue.remove();

            if(!visited[cur]){
                System.out.print(cur + ", ");
                visited[cur] = true;
                
                // get neighbour and add into queue of current
                for(int i =0; i<graph[cur].size(); i++){
                    Edge e = graph[cur].get(i);
                    graphQueue.add(e.destination);
                }
            }
        }

    }

    public static void bfsConnectedComponent(ArrayList<Edge>graph[] , int curr){

        boolean visited[] = new boolean[graph.length];

        // here we will marked false for visited graph
        for(int i=0; i<visited.length; i++){
            visited[i] = false;
        }

        for(int i =0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i =0; i< graph.length; i++){
            bfsConnectedComponentUtility(graph, i, visited);
        }

    }
    
    public static void main(String args[]){

        int vertex = 7;
        ArrayList<Edge>graph[] = new ArrayList[vertex];

        createGraph(graph, vertex);

        // DFS for unconnected or multiple connected
        dfsConnectedComponent(graph, 0);

        System.out.println();
        // BFS for unconnected or multiple connected
        bfsConnectedComponent(graph, 0);

    }
}
