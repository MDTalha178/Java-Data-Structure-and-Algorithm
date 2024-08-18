/**
 * Build_BST
 */
public class Build_BST {

    public static void main(String args[]){
        int nodes[] = {4,2,1,-1,-1,3,-1,-1,5,-1,6,-1,-1};
        // here we create BST Tree
        BST bstTree = new BST();

        // here we create binary Tree
        Node root = bstTree.buildBST(nodes, Integer.MAX_VALUE, Integer.MIN_VALUE);

        // here we will print root
        System.out.println("Root data fo Tree is "+ root.data);

        // here we will print preorder
        bstTree.preorder(root);
    }
}

/**
 * Node
 */
class Node {
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.right = null;
        this.left = null;
    }
    
}

// build BST class
class BST{
    public static int idx = -1;

    public  Node buildBST(int node[], int max, int min){
        idx++;
        
        if(idx >= node.length || node[idx] == -1){
            return null;
        }

        // here we will compare our root
        if(node[idx] < min || node[idx] > max){
            idx--;
            return null;
        }

        Node newNode = new Node(node[idx]);
        newNode.left = buildBST(node, newNode.data-1, min);
        newNode.right = buildBST(node, max, newNode.data+1);
        return newNode;
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