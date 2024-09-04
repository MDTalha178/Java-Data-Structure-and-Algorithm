import java.util.ArrayList;

class CreateGraph{
    public static void main(String args[]){
        
        /*   
         
        0------1
               
        */ 

        int vertex =  5;

        // creating arrayList
        ArrayList<Edge>[]graph =  new ArrayList[vertex];

        // here we will create a empty array
        for(int i=0; i<vertex; i++){
            graph[i] = new ArrayList<>();
        }

        // here we will add 0 vertex
        graph[0].add(new Edge(0,  3, 1));

        // here we will add 1 vertex
        graph[1].add(new Edge(1, 1, 2));
        graph[1].add(new Edge(1, 3, 3));
        graph[1].add(new Edge(1, 3, 0));


        // here will add 2 vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 1, 3));
        graph[2].add(new Edge(2, 2, 4));

        // here we will add 3 vertex
        graph[3].add(new Edge(3, 1, 2));
        graph[3].add(new Edge(3, 3, 1));

        // here we will add 4 vertex
        graph[4].add(new Edge(4, 2, 2));

        // here we will get neighbour of 2
        for(int i=0; i<graph[2].size(); i++){
            Edge edge = graph[2].get(i);
            System.out.print(edge.destination + ", ");
        }


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