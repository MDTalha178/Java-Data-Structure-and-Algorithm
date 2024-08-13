import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopView_OfTree {
    public static void getTopViewOfTree(Node root){
        
        HashMap<Integer, Node>countMap = new HashMap<>();
        Queue<Info>queue = new LinkedList<>();
        if(root == null){
            return;
        }

        // here we will use levelOrder Traversal
        queue.add(new Info(root, 0));
        queue.add(null);
        int max = Integer.MIN_VALUE;
        int min =Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Info currNode = queue.remove();
            if(currNode == null){
                if(queue.isEmpty()){
                    break;
                    
                }else{
                    queue.add(null);
                }
            }else{
                if(!countMap.containsKey(currNode.horizontal)){
                    countMap.put(currNode.horizontal, currNode.node);
                }
                if(currNode.node.left != null){
                    queue.add(new Info(currNode.node.left, currNode.horizontal-1));
                    min = Math.min(min, currNode.horizontal-1);
                }
                if(currNode.node.rigth != null){
                    queue.add(new Info(currNode.node.rigth, currNode.horizontal+1));
                    max = Math.max(max, currNode.horizontal+1);
                }
            }
           
        }
        for(int i = min; i<=max; i++){
            System.out.print(countMap.get(i).data + " ");
        }
            
    }
    public static void main(String args[]){
        // here we call our Binary Tree class
        int nodes[] = {1, 2 ,4, -1,-1,5,-1,-1,3,-1,6,-1,-1};
        InnerBuild_BianryTree bianryTree = new InnerBuild_BianryTree();
        Node root = bianryTree.buildBainaryTree(nodes);
        System.out.println(root.data);

        // here we will findout Top View oF Tree
        getTopViewOfTree(root);
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
