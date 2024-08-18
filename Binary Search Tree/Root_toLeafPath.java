import java.util.ArrayList;

public class Root_toLeafPath {
    public static void printPath(ArrayList<Integer>path){
        for(int i =0; i<path.size(); i++){
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }
    public static void pathToLeafRoot(Node root, ArrayList<Integer>path){
        // base case
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        pathToLeafRoot(root.left, path);
        pathToLeafRoot(root.right, path);
        path.remove(path.size()-1);
    }
    public static void main(String args[]){
        int nodes[] = {4,2,1,-1,-1,3,-1,-1,5,-1,6,-1,-1};
        ArrayList<Integer>path = new ArrayList<>();
        // here we will create our BST tree
        BSTTree bst = new BSTTree();

        // get our rott node
        Node root = bst.buildBST(nodes, Integer.MAX_VALUE, Integer.MIN_VALUE);

        // here we will print our root data
        System.out.println("Root node tree is " + root.data);

        // // here we will print our tree
        bst.preorder(root);
        System.out.println();
        // here we will print pathto roo
        pathToLeafRoot(root, path);

    }
}
