public class InvertBinaryTree {
    public static Node invertBinaryTree(Node root){
        if(root == null){
            return null;
        }

        Node left = invertBinaryTree(root.left);
        Node right = invertBinaryTree(root.rigth);

        // swap out node
        root.left = right;
        root.rigth = left;
        return root;

    }

    public static void preOrder(Node root){

        // base case 
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.rigth);
    }
    public static void main(String args[]){
        // here we call our Binary Tree class
        int nodes[] = {1, 2 ,3, -1,-1,4,-1,-1,5,-1,6,-1,-1};
        InnerBuild_BianryTree bianryTree = new InnerBuild_BianryTree();
        Node root = bianryTree.buildBainaryTree(nodes);
        System.out.println(root.data);

        invertBinaryTree(root);

        // preorder
        preOrder(root);

    }
}
