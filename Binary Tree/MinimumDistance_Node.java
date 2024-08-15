public class MinimumDistance_Node {
    public static Node getLCAoFNodes(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node left =  getLCAoFNodes(root.left, n1, n2);
        Node right = getLCAoFNodes(root.rigth, n1, n2);

        //if we not found at left
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;

    }
    public static int distance(Node root, int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int left = distance(root.left, n);
        int right = distance(root.rigth, n);

        if(left == -1 && right == -1){
            return -1;
        }else if(left == -1){
            return right +1;
        }else{
            return left +1;
        }

    }
    public static int minimumDitsanceNode(Node root, int n1, int n2){
        Node lca = getLCAoFNodes(root, n1, n2);
        int distanceN1 = distance(lca, n1);
        int distanceN2 = distance(lca, n2);

        int total = distanceN1 + distanceN2;
        return total;
    }
    public static void main(String args[]){
        // here we call our Binary Tree class
        int nodes[] = {1, 2 ,4, -1,-1,5,-1,-1,3,-1,6,-1,-1};
        InnerBuild_BianryTree bianryTree = new InnerBuild_BianryTree();
        Node root = bianryTree.buildBainaryTree(nodes);
        System.out.println("Binary Tree Root: " + root.data);
        System.out.println(root.data);

        // here we will get distance bewteen two nodes
        int distance = minimumDitsanceNode(root, (int) 4, (int)6);
        System.out.println(distance);


    }
}
