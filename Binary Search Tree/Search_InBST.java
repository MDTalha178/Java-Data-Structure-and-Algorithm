public class Search_InBST {
    public static void main(String args[]){
        int nodes[] = {4,2,1,-1,-1,3,-1,-1,5,-1,6,-1,-1};

        // here we will create our BST tree
        BSTTree bst = new BSTTree();

        // get our rott node
        Node root = bst.buildBST(nodes, Integer.MAX_VALUE, Integer.MIN_VALUE);

        // here we will print our root data
        System.out.println("Root node tree is " + root.data);

        // // here we will print our tree
        bst.preorder(root);

        // here we will check if its present in BST
        boolean search = bst.searchInBst(root, 5); 
        if(search){
            System.out.println("Key found in BST");
        }else{
            System.out.println("Key not found in BSt");
        }

    }
}


// here we will define our Node class
class TreeNode{

    int data;
    Node left;
    Node right;

    // calling our constructor
    TreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

// here we will implement our BST class
class BSTTree{

    // here we will define our indx
    public static int idx = -1;

    // here we will create our bST tree
    public Node  buildBST(int node[], int max, int min){

        idx ++;
        // base case
        if(node[idx] == -1){
            return null;
        }

        // here we will check for BST property
        if(node[idx] < min || node[idx] > max){
            idx--;
            return null;
        }

        // here we will create our node
        Node newNode = new Node(node[idx]);
        newNode.left = buildBST(node, newNode.data-1, min);
        newNode.right = buildBST(node, max, newNode.data + 1);
        return newNode;

    }

    // here will impement our search in BST
    public boolean searchInBst(Node root, int val){
        if(root == null){
            return false;
        }
        if(root.data == val){
            return true;
        }
        // here we check in which subtree have to find
        if(root.data > val){
            return searchInBst(root.left, val);
        }else{
            return searchInBst(root.right, val);
        }
    }

    // here we build out preorder traversal
    public void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
}