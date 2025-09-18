package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    TreeNode root;

    private static TreeNode insert(TreeNode node, int val){
        if(node == null) return new TreeNode(val);

        if(val < node.val){
            node.left = insert(node.left, val);
        }else if(val > node.val){
            node.right = insert(node.right, val);
        }
        return node;
    }

    public void insert(int val){
        root = insert(root, val);
    }

    private static void preOrder(TreeNode node){
        if(node == null) return;
        System.out.print(node.val + ", ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrder(){
        preOrder(root);
        System.out.println();
    }

    private static void inOrder(TreeNode node){
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.val + ", ");
        inOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
        System.out.println();
    }

    private static void postOrder(TreeNode node){
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + ", ");
    }

    public void postOrder(){
        postOrder(root);
        System.out.println();
    }

    private static void levelOrder(TreeNode node){
        if(node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            System.out.print(current.val + ", ");

            if(current.left != null) queue.offer(current.left);
            if(current.right != null) queue.offer(current.right);
        }
        System.out.println();
    }

    public void levelOrder(){
        levelOrder(root);
    }

    private static TreeNode search(TreeNode node, int target){
        if(node == null || node.val == target) return node;

        return (target < node.val)
                ? search(node.left, target)
                : search(node.right, target);
    }

    public boolean search (int target){
        return search(root, target) != null;
    }

    private static TreeNode delete(TreeNode node, int val){
        if(node == null) return node;

        if(val < node.val){
            node.left = delete(node.left, val);
        } else if(val > node.val){
            node.right = delete(node.right, val);
        }else{

            if(node.left == null) return node.right;
            if(node.right == null) return node.left;

            node.val = minValue(node).val;
            node.right = delete(node.right, node.val);
        }

        return node;
    }

    public void delete(int val){
        root = delete(root, val);
    }

    private static TreeNode minValue(TreeNode node){
        if(node == null) return node;

        TreeNode current = node;

        while(current.left != null){
            current = current.left;
        }
        return current;
    }

    public int minValue(){
        if(root == null) throw new IllegalStateException("Tree is Empty");
        return minValue(root).val;
    }

    private static TreeNode maxValue(TreeNode node){
        TreeNode current = node;

        while(current.right != null){
            current = current.right;
        }

        return current;
    }
    public int maxValue(){
        if(root == null) throw new IllegalStateException("Tree is Empty");
        return maxValue(root).val;
    }

    private int height(TreeNode node){
        if(node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int height(){
        return height(root);
    }

    private int checkBalance(TreeNode node){
        if(node == null) return 0;

        int left = checkBalance(node.left);
        int right = checkBalance(node.right);

        if(left == - 1 || right == -1 || Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left,right);
    }

    public boolean isBalanced(){
        return checkBalance(root) != -1;
    }

    private boolean validBST(TreeNode node, long min, long max){
        if(node == null) return true;

        if(node.val <= min || node.val >= max){
            return false;
        }

        return validBST(node.left, min, node.val) && validBST(node.right, node.val, max);
    }

    public boolean validBST(){
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

}
