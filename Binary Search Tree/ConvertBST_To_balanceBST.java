import java.util.ArrayList;

public class ConvertBST_To_balanceBST {

    public static Node getBalncesbst(ArrayList<Integer> nodes, int start, int end){

        // here we will add our base case
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;

        // here we we will create node
        Node root = new Node(nodes.get(mid));
        root.left = getBalncesbst(nodes, start, mid-1);
        root.right = getBalncesbst(nodes, mid+1, end);
        return root;
    }

    // here we will get our inorder
    public static void getInOrder(Node root, ArrayList<Integer>nodes){
        if(root == null){
            return;
        }
        getInOrder(root.left, nodes);
        nodes.add(root.data);
        getInOrder(root.right, nodes);

    }
    public static Node convertBstToBalancedTree(Node root){
        ArrayList<Integer>inorder = new ArrayList<>();
        getInOrder(root, inorder);

        root = getBalncesbst(inorder, 0, inorder.size()-1);
        return root;
    }
    public static void main(String args[]){
        int nodes[] = {4,2,1,-1,-1,3,-1,-1,5,-1,6,-1,-1};
        // here we create BST Tree
        BST bstTree = new BST();

        // here we create binary Tree
        Node root = bstTree.buildBST(nodes, Integer.MAX_VALUE, Integer.MIN_VALUE);

        // here we will print root
        System.out.println("Root data fo Tree is "+ root.data);

        // here we will print preorder
        bstTree.preorder(root);

        System.out.println();
        // here we will make  our bst
        root = convertBstToBalancedTree(root);

         // here we will print preorder
        bstTree.preorder(root);
    }
}
