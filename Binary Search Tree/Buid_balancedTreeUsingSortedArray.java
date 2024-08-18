public class Buid_balancedTreeUsingSortedArray {
    public static void main(String args[]){
        int nodes[] = {3,5,6,8,10,11,12};
        BSTUsingSortedArray bst = new BSTUsingSortedArray();

        // create bst using sorted srray
        Node root = bst.buidBSTUsingSortedArray(nodes, 0, nodes.length-1);
        System.out.println("Root Node is  " + root.data);

        // here we will print our BST
        bst.preOrder(root);
    }
}

class Node{
    int data;
    Node left;
    Node right;


    // create constructor
    Node(int data){
        this.data = data;
        this.left = this.right = null;

    }
}

class BSTUsingSortedArray{
    public Node buidBSTUsingSortedArray(int nodes[], int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(nodes[mid]);
        root.left = buidBSTUsingSortedArray(nodes, start, mid-1);
        root.right = buidBSTUsingSortedArray(nodes, mid+1, end);
        return root;
    }

    // preorder 
    public void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}