package Arrays;

import java.util.Arrays;

/* Merge Sort Algorithm
     - is a divide-and-conquer algorithm that sorts an array by first breaking it down into smaller arrays,
     and then building the array back together the correct way so that it is sorted.
     - using recursion is the most common approach

     # How it works
     1. Divide the unsorted array into two sub-arrays, half the size of the original
     2. Continue to divide the sub-arrays as long as the current piece of the array has more than one element.
     3. Merge two sub-arrays together by always putting the lowest value first.
     4. Keep merging until there are no sub-arrays left.

 - to split an array in two, the length of the array is divided by two, and then rounded down to get a value we call "mid"
 - This "mid" value is used as an index for where to split the array.
 - After the array is split, the sorting function calls itself with each half, so that the array can be split
   again recursively.
 - The splitting stops when a sub-array only consists of one element.
 -
 */
public class MergeSort {


//    public static void main(String[] args){
//
//        int [] numbers = {64, 34, 25, 12, 22, 11, 90, 5};
//
//        mergeSort(numbers);
//        System.out.println(Arrays.toString(numbers));
//    }

    public static void mergeSort(int[] array){
        int inputLength = array.length;

        if(inputLength < 2) return; // base case
        // we divide the input length to find the middle index
        int mid = inputLength / 2;
        // create new left and right arrays
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[inputLength - mid];

        System.arraycopy(array, 0, leftHalf, 0, mid);
        System.arraycopy(array, mid, rightHalf, 0, inputLength - mid);


        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(array, leftHalf, rightHalf);

    }

    private static void merge(int[] array, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while(i < leftSize && j < rightSize) {
            if(leftHalf[i] <= rightHalf[j]){
                array[k++] = leftHalf[i++];
            }else{
                array[k++] = rightHalf[j++];
            }
        }
        while(i < leftSize) {
            array[k++] = leftHalf[i++];
        }
        while(j < rightSize){
            array[k++] = rightHalf[j++];
        }
    }




}
