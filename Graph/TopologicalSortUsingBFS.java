import java.util.*;
public class TopologicalSortUsingBFS {

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
        // graph[0].add(new Edge(0, 1, 2));

        // // here we will add 1 vertex
        // graph[1].add(new Edge(1, 1, 0));

        // here we will add 2 vertex
        graph[2].add(new Edge(2, 1, 3));

        // here we will add 3 vertex
        graph[3].add(new Edge(3, 1, 1));
        
        graph[4].add(new Edge(4, 1, 0));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 1, 0));
        graph[5].add(new Edge(5, 1, 2));
        
    }

    public static void calculateIndegree(ArrayList<Edge>grapg[], int inDegree[]){

        for(int i=0; i<grapg.length; i++){
            int v = i;
            for(int j=0; j<grapg[v].size(); j++){
                
                Edge e = grapg[v].get(j);
                inDegree[e.destination]++;
            }
        }
    }

    public static void topologicalSortUsinfBFS(ArrayList<Edge>grapgh[]){

        int inDegree[] = new int[grapgh.length];
        calculateIndegree(grapgh, inDegree);

        Queue<Integer>bfsQeue = new LinkedList<>();
        
        for(int i =0; i<grapgh.length; i++){
            if(inDegree[i] == 0){
                bfsQeue.add(i);
            }
        }

        // Here we will use BFS
        while (!bfsQeue.isEmpty()) {
            
            int curr = bfsQeue.remove();

            System.out.print(curr + ", ");
            for(int i =0; i<grapgh[curr].size(); i++){

                Edge e = grapgh[curr].get(i);
                inDegree[e.destination]--;
                if(inDegree[e.destination] == 0){
                    bfsQeue.add(e.destination);
                }
            }
        }


    }

    public static void main(String args[]){

        int vertex = 6;
        ArrayList<Edge>graph[] = new ArrayList[vertex];

        createGraph(graph, vertex);

        topologicalSortUsinfBFS(graph);
        
    }
}
