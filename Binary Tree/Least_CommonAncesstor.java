import java.util.ArrayList;

public class Least_CommonAncesstor {
    public static boolean getPath(Node root, int n, ArrayList<Node> path){
         // base condition
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.data == n){
            return true;
        }
        boolean isFoundAtleft = getPath(root.left, n, path);
        boolean isFoundAtRight = getPath(root.rigth, n, path);

        if(isFoundAtRight || isFoundAtleft){
            return true;
        }
        // here we will remove
        path.remove(path.size()-1);
        return false;

    }
    public static void getCommonAncesstor(Node root, int n1, int n2){
        
        // here we will define out array which store path for n1 and n2
        ArrayList<Node>path1 = new ArrayList<>();
        ArrayList<Node>path2 = new ArrayList<>();

        // base condition
        if(root == null){
            return;
        }

        // get path
        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // using for loop to LCA
        int i =0;
        for(; i<path1.size() &&  i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        System.out.println(path1);
        Node lca = path1.get(i-1);
        System.out.println(lca.data);

    }

    /**
     * Main method to demonstrate the usage of the least common ancestor function.
     * It builds a binary tree from the given array of nodes, and then finds the
     * least common ancestor of two given nodes.
     *
     * @param args command line arguments
     */
    public static void main(String args[]){
        // Building a binary tree
        // here we call our Binary Tree class
        int nodes[] = {1, 2 ,4, -1,-1,5,-1,-1,3,-1,6,-1,-1};
        InnerBuild_BianryTree bianryTree = new InnerBuild_BianryTree();
        Node root = bianryTree.buildBainaryTree(nodes);
        System.out.println("Binary Tree Root: " + root.data);
        System.out.println(root.data);

        // Finding the least common ancestor of two nodes
        int n1 = 4; // Node 1
        int n2 = 6; // Node 2
        System.out.println("Least Common Ancestor of " + n1 + " and " + n2);
        getCommonAncesstor(root, n1, n2);
    }
}
