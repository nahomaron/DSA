package Trees;

public class ArrayTree {
    public static void main(String[] args){
        Character[] binaryTreeArray = {'R', 'A', 'B', 'C', 'D', 'E', 'F', null, null, null, null, null, null, 'G'};
        int rightChild = rightChildIndex(2);
        int leftChildOfRightChild = leftChildIndex(rightChild);
        Character data = getData(binaryTreeArray, leftChildOfRightChild);

        inOrder(binaryTreeArray, 0);
        preOrder(binaryTreeArray, 0);
        postOrder(binaryTreeArray, 0);

    }

    public static int leftChildIndex(int index){
        return 2 * index + 1;
    }

    public static int rightChildIndex(int index){
        return 2 * index + 2;
    }

    public static Character getData(Character[] binaryTreeArray, int index){
        if(index >=0 && index < binaryTreeArray.length){
            return binaryTreeArray[index];
        }
        return null;
    }

    public static void preOrder(Character[] tree, int index){
        if(index >= tree.length || tree[index] == null) return;
        System.out.print(tree[index] + ", ");
        preOrder(tree, index * 2 + 1);
        preOrder(tree, index * 2 + 2);
    }

    public static void inOrder(Character[] tree, int index){
        if(index >= tree.length || tree[index] == null) return;

        inOrder(tree, index * 2 + 1);
        System.out.print(tree[index] + ", ");
        inOrder(tree, index * 2 + 2);
    }

    public static void postOrder(Character[] tree, int index){
        if(index >= tree.length || tree[index] == null) return;

        postOrder(tree, index * 2 + 1);
        postOrder(tree, index * 2 + 2);
        System.out.print(tree[index] + ", ");
    }
}
