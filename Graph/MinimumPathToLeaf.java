import java.util.*;
public class MinimumPathToLeaf {
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
        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 1, 2));

        // here we will add 1 vertex
        graph[1].add(new Edge(1, 1, 8));
        graph[1].add(new Edge(1, 1, 2));

        graph[2].add(new Edge(2, 1, 9));

        // here we will add 2 vertex
        graph[8].add(new Edge(8, 1, 6));
        graph[8].add(new Edge(8, 1, 5));

        // here we will add 3 vertex
        // graph[3].add(new Edge(3, 1, 1));
        // graph[3].add(new Edge(3, 1, 5));

        // // here we will add 4 vertex
        // graph[4].add(new Edge(4, 1, 2));
        // graph[4].add(new Edge(4, 1, 5));

        // // here we will add 5 vertex
        // graph[5].add(new Edge(5, 1, 3));
        // graph[5].add(new Edge(5, 1, 4));
        // graph[5].add(new Edge(5, 1, 6));

        //  // here we will add 5 vertex
        // graph[6].add(new Edge(6, 1, 3));
        // graph[6].add(new Edge(6, 1, 4));
        
    }

    public static int minimumPathToLeaf(ArrayList<Edge>graph[]){
        Queue<Integer>garph_queue = new LinkedList<>();
        int count = 0;
        boolean visited[] = new boolean[graph.length];
        garph_queue.add(1);
        int min = -1;
        while (!garph_queue.isEmpty()) {
            
            int curr = garph_queue.remove();

            while (!visited[curr]) {
                visited[curr] = true;
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    if(e.destination > graph.length | graph[e.destination].size() == 0){
                        return count;
                    }
                    count++;
                    garph_queue.add(e.destination);
                }
            }
        }
        return min;

        

    }

    public static void main(String args[]){
        int vertex = 9;
        ArrayList<Edge>graph[] = new ArrayList[vertex];
        createGraph(graph, vertex);
        int min_path = minimumPathToLeaf(graph);
        System.out.println(min_path);
    }
}