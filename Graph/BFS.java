import java.util.ArrayList;
public class BFS {
    public static void bfs(ArrayList<Edge>graph[], int vertex){

        Queue<Int

    }
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
        graph[3].add(new Edge(5, 1, 3));
        graph[3].add(new Edge(5, 1, 4));
        graph[3].add(new Edge(5, 1, 6));

         // here we will add 5 vertex
        graph[3].add(new Edge(6, 1, 3));
        graph[3].add(new Edge(6, 1, 4));

    }

    public static void main(String args[]){

        int vertex = 7;
        ArrayList<Edge>[]graph = new ArrayList[vertex];

        // here we will create our graph
        createGraph(graph, vertex);

        bfs(graph, vertex);
        
    }
}

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
