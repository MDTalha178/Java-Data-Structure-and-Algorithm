import java.util.LinkedList;
import java.util.Queue;
public class Level_OrderTraversal {
    public static void main(String args[]){
        // here we call our Binary Tree class
        int nodes[] = {1, 2 ,4, -1,-1,5,-1,-1,3,-1,6,-1,-1};
        Build_BianryTree bianryTree = new Build_BianryTree();
        Node root = bianryTree.buildBinaryTree(nodes);
        System.out.println(root.data);

          // here we print using preporder traversal
        System.out.println("Using Level Order Traversal");
        bianryTree.level_OrderTraversal(root);
        
    }
}

// here we define our Node class
class Node{
    int data;
    Node left;
    Node rigth;

    // here we define our Constructor
    Node(int data){
        this.data = data;
        this.left = null;
        this.rigth = null;
    }
}

// here we define our Binary Tree
class Build_BianryTree{
    public static int idx = -1;
    public static Queue<Node>queue = new LinkedList<>();

    public Node buildBinaryTree(int nodes[]){
        idx++;
        
        // here first we check our base case
        if(nodes[idx] == -1){
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildBinaryTree(nodes);
        newNode.rigth =buildBinaryTree(nodes);

        // here we return our root
        return newNode;
    }
    public void level_OrderTraversal(Node root){
        // here first we check is null
        if(root == null){
            return;
        }

        // here we add root in queue
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node curr_root = queue.remove();

            // here first we check is this null
            if(curr_root == null){
                System.out.println();

                if(!queue.isEmpty()){
                    queue.add(null);
                }else{
                    break;
                }
            }else{
                System.out.print(curr_root.data + " ");
                if(curr_root.left != null){
                    queue.add(curr_root.left);
                }if(curr_root.rigth != null){
                    queue.add(curr_root.rigth);
                }
            }
        }
    }


}
