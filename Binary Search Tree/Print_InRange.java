public class Print_InRange {
    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }

        // here we will check root data is comingin our range or not
        if(root.data >= k1 && root.data <=k2){
            System.out.print(root.data + " ");
        }
        printInRange(root.left, k1, k2);
        printInRange(root.right, k1, k2);
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
        // print range
        printInRange(root, 4, 6);
    }
    
}
