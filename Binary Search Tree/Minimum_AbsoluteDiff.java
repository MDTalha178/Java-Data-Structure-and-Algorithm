public class Minimum_AbsoluteDiff {
    public static int maxdiff = 999999;
    public static int key = 0;
    public static void getMinimumAbsolute(Node root, int k){
        if(root == null){
            return;
        }
        if(maxdiff > Math.abs(k - root.data)){
            key =  root.data;
            maxdiff = Math.abs(k - root.data);

        }
        getMinimumAbsolute(root.left, k);
        getMinimumAbsolute(root.right, k);
        
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

        // here we will get our minimum absolute difference
        getMinimumAbsolute(root, 3);
        System.out.println();
        System.out.println(key);
        System.out.println(maxdiff);
    }
}

