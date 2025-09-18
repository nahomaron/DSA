package Trees;

public class Main {

    public static void main(String[] args){
        BST tree = new BST();
        tree.insert(7);
        tree.insert(9);
        tree.insert(10);
        tree.insert(4);
        tree.insert(2);
        tree.insert(5);
        tree.insert(8);

//        tree.inOrder();
//        tree.preOrder();
//        tree.postOrder();
//        tree.levelOrder();

//        System.out.println(tree.search(8));
//        System.out.println("Tree height: " + tree.height());
//        System.out.println(tree.minValue());
//        tree.delete(5);
//        tree.inOrder();

        System.out.println("Is Balanced: " + tree.isBalanced());
//
//        System.out.println(tree.maxValue());
//
        System.out.println("Is valid BST? = " + tree.validBST());
//
//        System.out.println(tree.search(5));


    }
}
