public class Height_ofTree {
    public static void main(String args[]){
        int nodes[] = {1, 2 ,4, -1,-1,5,-1,-1,3,-1,6,-1,-1};
        Build_BianryTree bianryTree = new Build_BianryTree();
        Node root = bianryTree.buildTree(nodes);

        // here we find out our height
        System.out.println("Height of Tree is " + bianryTree.heightOfTree(root));
    }
}

// Here we define our Node class
class Node{
    int data;
    Node right;
    Node left;

    // here we define our constructor
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// here we define our Binary Tree class
class Build_BianryTree{
    public static  int idx = -1;
    public Node buildTree(int node[]){
        idx++;

        // here first we check is child Node
        if(node[idx] == -1){
            return null;
        }

        Node newNode = new Node(node[idx]);

        // here we create left and rigth
        newNode.left = buildTree(node);
        newNode.right = buildTree(node);

        return newNode;

    }

    // here find height of tree
    public int heightOfTree(Node root){
        
        // here check for base case
        if(root == null){
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        return  Math.max(leftHeight, rightHeight) + 1;
    }
}
