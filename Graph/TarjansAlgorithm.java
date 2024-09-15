import java.util.ArrayList;

public class TarjansAlgorithm {
    public static void createGraph(ArrayList<Edge>graph[]){

        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 0, 1));
        graph[0].add(new Edge(0, 0, 2));
        graph[0].add(new Edge(0, 0,3));

        graph[1].add(new Edge(1, 0, 0));
        graph[1].add(new Edge(1, 0, 2));


        graph[2].add(new Edge(2, 0, 0));
        graph[2].add(new Edge(2, 0, 1));

        graph[3].add(new Edge(3, 0, 0));
        graph[3].add(new Edge(3, 0, 5));
        graph[3].add(new Edge(3, 0, 4));

        graph[4].add(new Edge(4, 0, 3));
        graph[4].add(new Edge(4, 0, 5));

        graph[5].add(new Edge(5, 0, 3));
        graph[5].add(new Edge(5, 0, 4));

    }
    
    public static void main(String args[]){
        int vertex = 7;
        ArrayList<Edge>graph[] = new ArrayList[vertex];

        createGraph(graph);

        TarjansAlgorithmImplementation  tarjan = new TarjansAlgorithmImplementation();

        tarjan.tarjanAlgo(graph);

    }
    
}

class TarjansAlgorithmImplementation{

    public void tarjanAlgo(ArrayList<Edge>graph[]){

        int dt[] = new int[graph.length];
        int low[] = new int[graph.length];
        int time =0;
        boolean visited[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                dfs(graph, i, -1, visited, dt, low, time);
            }
        }
    }

    public static void dfs(ArrayList<Edge>graph[], int curr, int parent, boolean visited[], int dt[], int low[], int time){

        visited[curr] = true;
        dt[curr] = low[curr] = ++time;

        for(int i =0; i<graph[curr].size(); i++){

            Edge e = graph[curr].get(i);
            int neighbour = e.destination;
            // case if neighbour and parent are same
            if(neighbour == parent){
                continue;
            }

            else if(!visited[neighbour]){
                dfs(graph, neighbour, curr, visited, dt, low, time);

                low[curr] = Math.min(low[curr], low[neighbour]);

                // check bridge condition
                if(dt[curr] < low[neighbour]){
                    System.out.println("Bridge Found -> " +  curr + "------------" + neighbour);
                }
            }
            else{
                low[curr] = Math.min(low[curr], dt[neighbour]);
            }
        }
    }
}
