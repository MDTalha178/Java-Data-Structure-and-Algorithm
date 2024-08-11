public class Count_Nodes {
    public static int countNodes(Node root){
        
        // here first we cheeck base case
        if(root == null){
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.rigth);

        return left + right + 1;
    }
    public static void main(String arsg[]){
        // here we call our Binary Tree class
        int nodes[] = {1, 2 ,4, -1,-1,5,-1,-1,3,-1,6,-1,-1};
        InnerBuild_BianryTree bianryTree = new InnerBuild_BianryTree();
        Node root = bianryTree.buildBainaryTree(nodes);
        System.out.println(root.data);

        // here we will get count of Nodes
        System.out.println("Count of Nodes is "+  countNodes(root));

    
    }
   
}
