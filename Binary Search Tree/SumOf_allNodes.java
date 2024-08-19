import java.util.ArrayList;

public class SumOf_allNodes {
    public static int sum_pair_count = 0;
    public static void calculatePair(int data, Node root, int k){
        if(root == null){
            return;
        }
        if(root.data + data == k){
            System.out.println(root.data + " " + data);
            sum_pair_count++;
        }
        calculatePair(data, root.left, k);
        calculatePair(data, root.right, k);
    }
    public static void getSumPairCount(Node root, Node sbtree, int k){
        if(root == null){
            return;
        }

        calculatePair(root.data, sbtree, k);
        getSumPairCount(root.left, sbtree, k);
        getSumPairCount(root.right, sbtree, k);
    }
    public static void main(String args[]){
        int nodes[] = {5,3,2,-1,-1,4,-1,-1,7,6,-1,-1,8,-1,-1};
        int subnodes[] = {10,6,3,-1,-1,8,-1,-1,15,11,-1,-1,18,-1,-1};
        // here we create BST Tree
        BST bstTree = new BST();

        // here we create binary Tree
        Node root = bstTree.buildBST(nodes, Integer.MAX_VALUE, Integer.MIN_VALUE);
        BST newSubTree = new BST();
        Node subtree = newSubTree.buildBST(subnodes, Integer.MAX_VALUE, Integer.MIN_VALUE);
        // here we will print root
        System.out.println("Root data fo Tree is "+ root.data);
        System.out.println("Root data for subtree" + subtree.data);
        // here we will print preorder
        bstTree.preorder(root);
        System.out.println();
        getSumPairCount(root, subtree, 16);
        System.out.println("Pair count is " + sum_pair_count);
    }
}
