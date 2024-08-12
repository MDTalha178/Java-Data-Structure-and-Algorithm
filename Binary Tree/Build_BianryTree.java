class Build_BianryTree{
    public static void main(String args[]){
        // here we call our Binary Tree class
        int nodes[] = {1, 2 ,4, -1,-1,5,-1,-1,3,-1,6,-1,-1};
        InnerBuild_BianryTree bianryTree = new InnerBuild_BianryTree();
        Node root = bianryTree.buildBainaryTree(nodes);
        System.out.println(root.data);

        // here we print using preporder traversal
        System.out.println("Using Preorder Traversal");
        bianryTree.preOrderTravesal(root);

        // here we will be using Inorder traversal
        System.out.println("Using Inorder Traversal");
        bianryTree.inOrderTraversal(root);

        // here we will be using Inorder traversal
        System.out.println("Using PostOrder Traversal");
        bianryTree.postOrderTraversal(root);

    }
}

// here we define Node class
class Node{
    int data;
    Node left;
    Node rigth;

    // here we define our constructor
    Node(int data){
        this.data = data;
        this.left = null;
        this.rigth = null;
    }
}

// here we define our Binary Tree class
/**
 * InnerBuild_BianryTree
 */
class InnerBuild_BianryTree {
    public int idx =-1;
    InnerBuild_BianryTree(int idx){
        this.idx = idx;
    }

    InnerBuild_BianryTree() {
        this.idx = -1; 
    }
    public Node buildBainaryTree(int node[]){
        idx++;
        if(node[idx] == -1){
            return null;
        }
        Node newNode = new Node(node[idx]);
        newNode.left = buildBainaryTree(node);
        newNode.rigth = buildBainaryTree(node);

        return newNode;
    }

    // here we willl traverse using preorder
    public void preOrderTravesal(Node root){
        // here first check base case
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrderTravesal(root.left);
        preOrderTravesal(root.rigth);
    }

    // here we willl traverse using Inorder
    public void inOrderTraversal(Node root){
        // here first we check our base case
        if(root == null){
            return;
        }

        // first left root
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.rigth);
    }

    // here we will be using post Order Traversal
    public void postOrderTraversal(Node root){

        // here first check our base case
        if(root == null){
            return;
        }

        // left root
        postOrderTraversal(root.left);
        postOrderTraversal(root.rigth);
        System.out.print(root.data + " ");
    }
    
}