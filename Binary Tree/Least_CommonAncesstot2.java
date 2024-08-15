public class Least_CommonAncesstot2 {
    public static Node leastCommnoAncesstor(Node root, int n1, int n2){
        if(root == null || root.data == n2 || root.data == n1){
            return root;
        }
        Node leftNode = leastCommnoAncesstor(root.left, n1, n2);
        Node rightNode = leastCommnoAncesstor(root.rigth, n1, n2);

        if(leftNode == null){
            return rightNode;
        }
        if(rightNode == null){
            return leftNode;
        }
        return root;

    }
    public static void main(String args[]){
        // here we call our Binary Tree class
        int nodes[] = {1, 2 ,4, -1,-1,5,-1,-1,3,-1,6,-1,-1};
        InnerBuild_BianryTree bianryTree = new InnerBuild_BianryTree();
        Node root = bianryTree.buildBainaryTree(nodes);
        System.out.println(root.data);

        // here we call  ancesstor
         // Finding the least common ancestor of two nodes
        int n1 = 4; // Node 1
        int n2 = 6; // Node 2
        Node ancesstor = leastCommnoAncesstor(root, n1, n2);
        System.out.println(ancesstor.data); 
    }
}
