import java.util.*;;
public class KosaRajuAlgorith {

    public static void createGraph(ArrayList<Edge>graph[]){

        for(int i =0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 3));
        graph[0].add(new Edge(0, 1, 2));

        graph[1].add(new Edge(1, 1, 0));

        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 1, 4));

    }
    
    public static void main(String args[]){

        int vertex = 5;
        ArrayList<Edge>graph[] = new ArrayList[vertex];

        createGraph(graph);

        KosaRajuAlgorithmImpelentation  kosaAlgo = new KosaRajuAlgorithmImpelentation();
        kosaAlgo.kosaRajuAlgorithm(graph);
    }
}

class KosaRajuAlgorithmImpelentation{


    public void kosaRajuAlgorithm(ArrayList<Edge>graph[]){

        boolean visited[] = new boolean[graph.length];

        // Step1-> get all node in stack using Toplologocal Sort
        Stack<Integer>st = new Stack<>();
        for(int i =0; i<graph.length; i++){
            if(!visited[i]){
                topologicalSort(graph, i, visited, st);

            }
        }
        // Step2-> transpose the graph
        ArrayList<Edge>transPoseGarph[] = new ArrayList[graph.length];
        for(int i=0; i<transPoseGarph.length; i++){
            visited[i] = false;
            transPoseGarph[i] = new ArrayList<>();
        }
        transPoseGarph(graph, transPoseGarph, visited);

        // Step 3 perform DFS on Transpose graph accoding to the stack node
        while (!st.empty()) {
            int curr = st.pop();
            if(!visited[curr]){
                System.out.print("Strongly Conntected Node -> ");
                dfsAcToStackNode(transPoseGarph, visited, curr);
                System.out.println();
            }
            
        }


    }

    public void topologicalSort(ArrayList<Edge>graph[], int curr, boolean visited[], Stack<Integer> st){

        visited[curr] = true;

        for(int i =0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.destination]){
                topologicalSort(graph, e.destination, visited, st);
            }
        }
        st.push(curr);

    }

    public static void transPoseGarph(ArrayList<Edge>graph[], ArrayList<Edge>transpose[], boolean visited[]){
        
        for(int i=0; i<graph.length; i++){
            for(int j =0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);

                int src = e.src;
                int des = e.destination;
                transpose[des].add(new Edge(des, 1, src));
            }
        }
    }

    public static void dfsAcToStackNode(ArrayList<Edge>transpose[], boolean visited[], int curr){

        visited[curr] = true;
        System.out.print(curr + " ");
        for(int i =0; i<transpose[curr].size(); i++){
            Edge e = transpose[curr].get(i);
            if(!visited[e.destination]){
                dfsAcToStackNode(transpose, visited, e.destination);
            }
        }

    }
}


