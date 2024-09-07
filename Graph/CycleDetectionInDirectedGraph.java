import java.util.*;;
public class CycleDetectionInDirectedGraph {
    public static boolean cycleDetectionInDirectedGraph(ArrayList<Edge>[] graph){

        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){

            if(!visited[i]){
                if(cycleDetectionInDirectedGraphUtils(graph, i, visited, stack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cycleDetectionInDirectedGraphUtils(ArrayList<Edge>[] graph, int curr, boolean visited[], boolean stack[]){
        stack[curr] = true;
        visited[curr] = true;

        for(int j=0; j<graph[curr].size(); j++){
            Edge e  = graph[curr].get(j);
            if(stack[curr]){
                return true;
            }else if(!visited[e.destination] && cycleDetectionInDirectedGraphUtils(graph, e.destination, visited, stack)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    public static void createGraph(ArrayList<Edge>[] graph, int vertex){

        // here we will assign empty graph
        for(int i =0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }


        // Here we will add 0 vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 1, 2));

        // here we will add 1 vertex
        graph[1].add(new Edge(2, 1, 3));
        graph[1].add(new Edge(2, 1, 0));

        // here we will add 2 vertex
        graph[2].add(new Edge(1, 1, 0));
        graph[2].add(new Edge(1, 1, 3));

        // here we will add 3 vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 1, 2));

        // here we will add 4 vertex
        graph[4].add(new Edge(4, 1, 2));
        graph[4].add(new Edge(4, 1, 3));


    }
    public static void main(String args[]){

        int vertex = 5;
        ArrayList<Edge>graph[] = new ArrayList[vertex];

        createGraph(graph, vertex);

        System.out.println(cycleDetectionInDirectedGraph(graph));

    }
}
