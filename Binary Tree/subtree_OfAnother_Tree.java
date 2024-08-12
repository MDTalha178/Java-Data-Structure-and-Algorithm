public class subtree_OfAnother_Tree {
    public static boolean isIdentical(Node root, Node subTree){
        if(root == null && subTree == null){
            return true;
        }
        else if(root.data != subTree.data || root == null || subTree == null){
            return false;
        }
        if(!isIdentical(root.left, subTree.left)) return false;
        if(!isIdentical(root.rigth, subTree.rigth)) return false;
        return true;
    }
    public static boolean isSubTreeOfOtherTree(Node root, Node subTree){
        if(root == null){
            return false;
        }
        if(root.data == subTree.data){
            if(isIdentical(root, subTree)){
                return true;
            }
        }
        boolean left = isSubTreeOfOtherTree(root.left, subTree);
        boolean right = isSubTreeOfOtherTree(root.rigth, subTree);
        return left || right;
        
    }
    public static void main(String args[]){
        // here we call our Binary Tree class
        int nodes[] = {1, 2 ,4, -1,-1,5,-1,-1,3,-1,6,-1,-1};
        int subNodes[] = {2, 2,-1,-1, 5, -1, -1, -1};
        InnerBuild_BianryTree bianryTree = new InnerBuild_BianryTree(-1);
        Node root = bianryTree.buildBainaryTree(nodes);
        InnerBuild_BianryTree subNode = new InnerBuild_BianryTree(-1);
        Node subTree = subNode.buildBainaryTree(subNodes);
        System.out.println(subTree.data);

        boolean isSubTreeOfOtherTree = isSubTreeOfOtherTree(root, subTree);
        System.out.println(isSubTreeOfOtherTree);

    }
}
