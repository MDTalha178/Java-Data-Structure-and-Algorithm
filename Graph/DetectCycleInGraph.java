import java.util.ArrayList;

public class DetectCycleInGraph {

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

    public static boolean detectCycleInGraphUtility(ArrayList<Edge>[] graph, boolean visited[], int cur, int parent){

        visited[cur] = true;

        for(int i =0; i<graph[cur].size(); i++){

            Edge e = graph[cur].get(i);
            if(!visited[e.destination] && detectCycleInGraphUtility(graph, visited, e.destination, cur)){
                return true;
            }
            else if(visited[e.destination] && e.destination != parent){
                return true;
            }
        }
        return false;
    }

    public static boolean detectCycleInGraph(ArrayList<Edge>[] graph, int curr){
        
        boolean visited[] = new boolean[graph.length];

        for(int i =0; i<graph.length; i++){

            if(!visited[i]){
                if(detectCycleInGraphUtility(graph, visited, i, -1)){
                    return true;
                };
            }
        }
        return false;

    }
    
    public static void main(String args[]){
        int vertex = 7;
        ArrayList<Edge>graph[] = new ArrayList[vertex];

        createGraph(graph, vertex);

        System.out.println(detectCycleInGraph(graph, 0));
    }
}
