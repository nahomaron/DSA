package Trees;

public class Tree {

    static class TreeNode{
        String val;
        TreeNode left;
        TreeNode right;

        public TreeNode(String val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void preOrderTraversal(TreeNode node){
        if(node == null) return;

        System.out.print(node.val + ", ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public static void inOrderTraversal(TreeNode node){
        if(node == null) return;
        inOrderTraversal(node.left);
        System.out.print(node.val + ", ");
        inOrderTraversal(node.right);
    }

    public static void postOrderTraversal(TreeNode node){
        if(node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.val + ", ");
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode("R");
        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeE = new TreeNode("E");
        TreeNode nodeF = new TreeNode("F");
        TreeNode nodeG = new TreeNode("G");

        root.left = nodeA;
        root.right = nodeB;

        nodeA.left = nodeC;
        nodeA.right = nodeD;

        nodeB.left = nodeE;
        nodeB.right = nodeF;

        nodeF.left = nodeG;

        preOrderTraversal(root);
        System.out.println("");
        inOrderTraversal(root);
        System.out.println("");
        postOrderTraversal(root);
    }
}
