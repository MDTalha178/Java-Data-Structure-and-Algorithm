public class Sum_ofNodes {
    public static int getSumOfNodes(Node root){

        // first we check base case
        if(root == null){
            return 0;
        }

        int leftSum = getSumOfNodes(root.left);
        int rightSum = getSumOfNodes(root.rigth);

        // here we calculate total sum and return total sum
        return  root.data + (leftSum + rightSum);
    }
    public static void main(String args[]){
        // here we call our Binary Tree class
        int nodes[] = {1, 2 ,4, -1,-1,5,-1,-1,3,-1,6,-1,-1};
        InnerBuild_BianryTree bianryTree = new InnerBuild_BianryTree();
        Node root = bianryTree.buildBainaryTree(nodes);
        System.out.println(root.data);

        // here we will get sum of nodes
        int sumOfNodes = getSumOfNodes(root);
        System.out.println("Sum of Nodes is " + sumOfNodes);
    }
}
