import java.util.*;;
public class AllPathFromSourceToTarget {
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
        graph[0].add(new Edge(0, 1, 3));

        // here we will add 1 vertex
        // graph[1].add(new Edge(1, 1, 0));
        // graph[1].add(new Edge(1, 1, 5));

        // here we will add 2 vertex
        graph[2].add(new Edge(2, 1, 3));

        // here we will add 3 vertex
        graph[3].add(new Edge(3, 1, 1));
        
        graph[4].add(new Edge(4, 1, 0));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 1, 0));
        graph[5].add(new Edge(5, 1, 2));
        
    }
    public static void allPathFromSourceToTarget(ArrayList<Edge>graph[], int src, int target, String path){

        if(src == target){
            System.out.println(path+target);
        }

        for(int i =0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            allPathFromSourceToTarget(graph, e.destination, target, path+src);
        }
    }
    public static void main(String args[]){
        int vertex = 6;
        ArrayList<Edge>graph[] = new ArrayList[vertex];

        createGraph(graph, vertex);
        int src = 5;
        int target = 1;
        allPathFromSourceToTarget(graph, src, target, "");
    }
}
