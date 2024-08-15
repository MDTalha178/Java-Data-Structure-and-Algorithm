public class Transform_SumOfTree {
    public static int transaformSumOfTree(Node root){
        
        // base case
        if(root == null){
            return 0;
        }

        int leftDist = transaformSumOfTree(root.left);
        int rightNode = transaformSumOfTree(root.rigth);

        int data = root.data;
        int newLeft = root.left == null  ? 0 : root.left.data;
        int  newright = root.rigth == null ? 0 : root.rigth.data;
        root.data = leftDist + newLeft + rightNode + newright;
        return data;
    }
    public static void preOrder(Node root){
        
        // base case
        if(root == null){
            return;
        }

        // here we will print our root
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.rigth);

    }
    public static void main(String args[]){
        // here we call our Binary Tree class
        int nodes[] = {1, 2 ,4, -1,-1,5,-1,-1,3,-1,6,-1,-1};
        InnerBuild_BianryTree bianryTree = new InnerBuild_BianryTree();
        Node root = bianryTree.buildBainaryTree(nodes);
        System.out.println(root.data);

        transaformSumOfTree(root);
        preOrder(root);

    }
}
