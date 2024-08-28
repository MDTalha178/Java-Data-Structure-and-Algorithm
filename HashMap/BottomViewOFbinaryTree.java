import java.util.*;;
public class BottomViewOFbinaryTree {

    public static void topViewOfTree(Node root){

        HashMap<Integer, Node> sumOfNode = new HashMap<>();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        Queue<Info>treeQueue = new LinkedList<>();
        treeQueue.add(new Info(root, 0));
        treeQueue.add(null);

        while (!treeQueue.isEmpty()) {
            Info curr = treeQueue.remove();

            if(curr == null){
                if(treeQueue.isEmpty()){
                    break;
                }else{
                    treeQueue.add(null);
                }
            }
            else{
                if(!sumOfNode.containsKey(curr.horizontal)){
                    sumOfNode.put(curr.horizontal, curr.node);
                }
    
                if(curr.node.left != null){
                    treeQueue.add(new Info(curr.node.left, curr.horizontal-1));
                    min = Math.min(min, curr.horizontal);
    
                }
                if(curr.node.right != null){
                    treeQueue.add(new Info(curr.node.right, curr.horizontal-1));
                    max = Math.max(max, curr.horizontal + 1);
                }
            }

            
        }

        for(int i= min; i<max; i++){
            System.out.println(sumOfNode.get(i));
        }
    }
    public static void main(String args[]){
        int node[] = {1,2,-1,-1,3,-1,-1};

        BuildTree  tree = new BuildTree();

        Node root = tree.buildTree(node);

        tree.preOrder(root);

        topViewOfTree(root);
        
    }
}

class Info{
    Node node;
    int horizontal;

    Info(Node node, int horizontal){
        this.node = node;
        this.horizontal = horizontal;
    }
}

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BuildTree{

    public static int idx = -1;

    public Node buildTree(int node[]){
        idx++;

        if(node[idx] == -1){
            return null;
        }

        Node newNode = new Node(node[idx]);
        newNode.left = buildTree(node);
        newNode.right = buildTree(node);

        return newNode;
    }

    public void preOrder(Node root){

        if(root == null){
            return;
        }

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
}
