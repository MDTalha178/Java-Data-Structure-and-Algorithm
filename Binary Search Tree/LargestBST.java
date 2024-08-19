public class LargestBST {
    public static int max_node = 0;
    public static Info largestBst(Node root){
        
        // here we will add base case
        if(root == null){
            return new Info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        Info leftInfo = largestBst(root.left);
        Info rigInfo = largestBst(root.right);

        // here we will caluclate for root Node
        int min = Math.min(root.data, Math.min(leftInfo.min, rigInfo.min));
        int max = Math.max(root.data, Math.max(rigInfo.max, leftInfo.max));

        int size = leftInfo.size + rigInfo.size +1 ;

        if(root.data >= rigInfo.min || root.data <= leftInfo.max){
            return new Info(false, size, max, min);
        }

        if(leftInfo.isBst && rigInfo.isBst){
            max_node = Math.max(max_node, size);
            return new Info(true, size, max, min);
        }
        return new Info(false, size, max, min);

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

        //
        Info info = largestBst(root);
        System.out.println(max_node);
    }
}

class Info{
    boolean isBst;
    int size;
    int max;
    int min;

    // here we will create constructor
    Info(boolean isBst, int size, int max, int min){
        this.isBst = isBst;
        this.size = size;
        this.max = max;
        this.min = min;
    }
}
