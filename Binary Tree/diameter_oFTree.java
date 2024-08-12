public class diameter_oFTree {
    public static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.rigth);
        return Math.max(leftHeight, rightHeight) + 1;
    } 
    public static int diameterOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftDiameter = diameterOfTree(root.left);
        int leftheight = heightOfTree(root.left);
        int rigthDiameter = diameterOfTree(root.rigth);
        int rightHeight = heightOfTree(root.rigth);
        int total_height = leftheight + rightHeight + 1;
        int final_diameter = Math.max(Math.max(leftDiameter, rigthDiameter), total_height);
        return final_diameter;
    }
    public static void main(String args[]){
        // here we call our Binary Tree class
        int nodes[] = {1, 2 ,4, -1,-1,5,-1,-1,3,-1,6,-1,-1};
        InnerBuild_BianryTree bianryTree = new InnerBuild_BianryTree();
        Node root = bianryTree.buildBainaryTree(nodes);
        System.out.println(root.data);

        // here we will find out our diameter
        int diameter = diameterOfTree(root);
        System.out.println(diameter);
    }
}
