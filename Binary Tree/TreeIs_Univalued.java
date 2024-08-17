public class TreeIs_Univalued {
    public static boolean checkTreeisUnivalued(Node root){
        if(root == null){
            return true;
        }

        if(root.left != null && root.data != root.left.data){
            return false;
        }
        if(root.rigth != null && root.data != root.rigth.data){
            return false;
        }

        boolean leftRoot = checkTreeisUnivalued(root.left);
        boolean rightRoot = checkTreeisUnivalued(root.rigth);

        return leftRoot && rightRoot;
    }
    public static void main(String args[]){
        // here we call our Binary Tree class
        int nodes[] = {1, 2 ,2, -1,-1,2,-1,-1,2,-1,2,-1,-1};
        InnerBuild_BianryTree bianryTree = new InnerBuild_BianryTree();
        Node root = bianryTree.buildBainaryTree(nodes);
        System.out.println(root.data);

        boolean isUnivalued = checkTreeisUnivalued(root);
        System.out.println(isUnivalued);
    }
}
