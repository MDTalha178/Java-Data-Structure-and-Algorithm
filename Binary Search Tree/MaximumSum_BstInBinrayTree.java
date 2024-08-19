public class MaximumSum_BstInBinrayTree {

    public static Info getMaximumSumOfBst(Node root){
        if(root == null){
            return new Info(true, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        Info leftInfo = getMaximumSumOfBst(root.left);
        Info rightInfo = getMaximumSumOfBst(root.rigth);
        
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, leftInfo.max));
        int max_sum = Math.max(leftInfo.max_sum, rightInfo.max_sum);

        // here we will check for our root
        if(root.data <= leftInfo.max || root.data >= rightInfo.min){
            return new Info(false, max_sum ,0, max, min);
        }

        if(leftInfo.isBst && rightInfo.isBst){
            int cursum = leftInfo.cur_summ + rightInfo.cur_summ + root.data;
            max_sum += root.data;
            return new Info(true, max_sum, cursum, max_sum, max_sum);
        }
        return new Info(false, max_sum, 0, max, min);
    }

    public static void main(String args[]){
        // here we create BST Tree
        int nodes[] = {5,9,6,8,-1,-1,7,-1,-1,-1,2,-1,-1};
        InnerBuild_BianryTree binaryTree = new InnerBuild_BianryTree();

        // here we create binary Tree
        Node root = binaryTree.buildBainaryTree(nodes);
        Info maximum_data = getMaximumSumOfBst(root);
        System.out.println(maximum_data.max_sum);;

    }
}

class Info{
    boolean isBst;
    int max_sum;
    int cur_summ;
    int max;
    int min;

    Info(boolean isBst, int max_sum, int cur_summ, int max, int min){
        this.isBst = isBst;
        this.cur_summ = cur_summ;
        this.max = max;
        this.min = min;
        this.max_sum = max_sum;
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
}
