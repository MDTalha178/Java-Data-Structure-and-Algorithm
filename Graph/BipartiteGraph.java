import java.util.ArrayList;
import java.util.*;
public class BipartiteGraph {

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

        // // here we will add 4 vertex
        // graph[4].add(new Edge(4, 1, 2));
        // graph[4].add(new Edge(4, 1, 3));


    }

    public static boolean isBiparTitieGraph(ArrayList<Edge>[] graph){

        Queue<Integer>queue = new LinkedList<>();

        int color[] = new int[graph.length];

        for(int i=0; i<graph.length; i++){
            color[i] = -1;
        }

        for(int i=0; i<graph.length; i++){

            if(color[i] == -1){
                queue.add(i);
                color[i] = 0;
                while (!queue.isEmpty()) {
                    int curr = queue.remove();

                    for(int j=0; j<graph[curr].size(); j++){

                        Edge  e = graph[curr].get(j);
                        if(color[e.destination] == -1){
                            int nextColor = color[curr] == 0 ? 1:0;
                            color[e.destination] = nextColor;
                            queue.add(e.destination);
                        }else if(color[e.destination] == color[curr]){
                            return false;
                        }
                        
                    }
                }
            }
        }
        return true;
    }
    
    public static void main(String args[]){
        int vertex = 4;
        ArrayList<Edge>graph[] = new ArrayList[vertex];

        createGraph(graph, vertex);

        System.out.println(isBiparTitieGraph(graph));
    }
}
