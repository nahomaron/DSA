package Practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import Arrays.MergeSort;

public class Practice_1 {

    public static void main(String[] args){


        int[] numbers = new int[20];

        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        mergeSort(numbers);

        System.out.println(Arrays.toString(numbers));
    }

    public static void mergeSort(int[] array) {
        int inputLength = array.length;
        int mid = inputLength / 2;

        if(inputLength <= 1) return;

        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[inputLength - mid];

        System.arraycopy(array, 0, leftHalf, 0, mid);
        System.arraycopy(array, mid, rightHalf, 0, inputLength - mid);

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(array, leftHalf, rightHalf);
    }

    public static void merge(int[] array, int[] leftHalf, int[] rightHalf) {

        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while(leftSize > i && rightSize > j) {
            if(leftHalf[i] < rightHalf[j]) {
                array[k++] = leftHalf[i++];
            }else {
                array[k++] = rightHalf[j++];
            }
        }

        while(leftSize > i) {
            array[k++] = leftHalf[i++];
        }
        while(rightSize > j) {
            array[k++] = rightHalf[j++];
        }

    }
}
