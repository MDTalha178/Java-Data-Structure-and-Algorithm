import java.util.*;
public class TopologicalSorting {
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

        /**
         * This function is a utility function for topological sorting.
         * It is a recursive function which will do a depth first search
         * and whenever it will finish a node, it will push it into stack.
         * @param graph is the adjacency list of graph
         * @param curr is the current node
         * @param visited is a boolean array which will keep track of visited nodes
         * @param stack is a stack which will store the elements in order of finish time
         */

    public static void topologicalSortUtils(ArrayList<Edge>[] graph, int curr, boolean visited[], Stack<Integer>stack){

        visited[curr] = true;
        for(int i =0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.destination]){
                topologicalSortUtils(graph, e.destination, visited, stack);
            }
        }
        stack.push(curr);
    }

        /**
         * This function will do a topological sorting of given graph.
         * It will use a utility function which will do a depth first search
         * and whenever it will finish a node, it will push it into stack.
         * Finally the function will print the elements in order of finish time.
         * @param graph is the adjacency list of graph
         */

    public static void topologicalSort(ArrayList<Edge>[] graph){

        Stack<Integer>stack = new Stack<>();
        boolean visited[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                topologicalSortUtils(graph, i, visited, stack);
            }
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }

    }

        /**
         * This is the main function which will create a graph and call a topological sort function.
         * The graph which is created is as follows:
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

    public static void main(String args[]){

        int vertex = 6;
        ArrayList<Edge>graph[] = new ArrayList[vertex];

        createGraph(graph, vertex);
        topologicalSort(graph);

    }
}
