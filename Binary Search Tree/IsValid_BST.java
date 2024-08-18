public class IsValid_BST {
    public static boolean isValidBst(Node root, Node max, Node min){
        if(root == null){
            return true;
        }
        if(min != null && root.data <= min.data){
            return false;
        }
        else if(max !=null && root.data >= max.data){
            return false;
        }
        return isValidBst(root.left, root, min) && isValidBst(root.right, max, root);
    }
    public static void main(String args[]){
        int nodes[] = {4,2,1,-1,-1,3,-1,-1,5,-1,6,-1,-1};
        // here we will check if our tree is valid or not
        BSTTree bst = new BSTTree();
        Node root = bst.buildBST(nodes, Integer.MAX_VALUE, Integer.MIN_VALUE);

        System.out.println(isValidBst(root, null, null));
    }
}
