public class diameter_ofTree2 {
    public static DiameterInfo diameterOfTree(Node root){

        // base case
        if(root == null){
            DiameterInfo  dia = new DiameterInfo(0, 0);
            return dia;
        }

        // here we caluclate height and daiameter both
        DiameterInfo leftInfo = diameterOfTree(root.left);
        DiameterInfo rightInfo = diameterOfTree(root.rigth);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int diameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter) , leftInfo.height + rightInfo.height + 1);
        return new DiameterInfo(Math.max(diameter, height), height);

    }
    public static void main(String args[]){
        // here we call our Binary Tree class
        int nodes[] = {1, 2 ,4, -1,-1,5,-1,-1,3,-1,6,-1,-1};
        InnerBuild_BianryTree bianryTree = new InnerBuild_BianryTree();
        Node root = bianryTree.buildBainaryTree(nodes);
        System.out.println(root.data);

        DiameterInfo diameterInfo = diameterOfTree(root);
        System.out.println(diameterInfo.diameter);
    }
}

class DiameterInfo{
    int diameter;
    int height;

    DiameterInfo(int diameter, int height){
        this.height = height;
        this.diameter = diameter;
    }
}
