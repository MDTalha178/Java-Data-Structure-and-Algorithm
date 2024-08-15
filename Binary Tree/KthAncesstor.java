public class KthAncesstor {
    public static int getKthAncesstor(Node root, int n, int k){

        // base case
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        // calculate left distance
        int leftDist = getKthAncesstor(root.left, n, k);
        int rightDist = getKthAncesstor(root.rigth, n, k);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }

        int maxDistance = Math.max(leftDist, rightDist);
        if(maxDistance + 1 == k){
            System.out.println(root.data);
        }

        return maxDistance+1;
    }
    public static void main(String args[]){
        // Building a binary tree
        // here we call our Binary Tree class
        int nodes[] = {1, 2 ,4, -1,-1,5,-1,-1,3,-1,6,-1,-1};
        InnerBuild_BianryTree bianryTree = new InnerBuild_BianryTree();
        Node root = bianryTree.buildBainaryTree(nodes);
        System.out.println("Binary Tree Root: " + root.data);
        System.out.println(root.data);

        getKthAncesstor(root, 5, 1);
    }
}
