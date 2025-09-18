package Arrays;

import java.util.Arrays;

/* Quicksort algorithm
  - takes array of values, chooses on of the values as a pivot element, and moves the other values so that
  the lower values are to the left of the pivot and the higher values are to the right of the pivot.

 # how it works
  1. choose a pivot element
  2. order the rest of the array so that left of the pivot are lower values and right of the pivot are higher values
  3. swap pivot element with the first element of the higher values - so the pivot becomes the center
  4. do the same operation recursively on the sub-arrays on the left and right sides of the pivot element


  # Time complexity =  O(n log n)
    Average = O(n log n)
    worst = O(n2)
 */
public class QuickSort {
    public static void main(String[] args){

        int [] numbers = {64, 34, 25, 12, 22, 11, 90, 5};

        quickSort(numbers, 0, numbers.length -1);

        System.out.println(Arrays.toString(numbers));

    }

    public static void quickSort(int[] array, int lowIndex, int highIndex){

        // as for all recursive functions, we have to set the base case otherwise we will face stackoverflow error
        if (highIndex <= lowIndex) return; // base case

        // pivot here is the index in which the pivot element is placed after the process of partitioning
        int pivot = partition(array, lowIndex, highIndex);
        quickSort(array, lowIndex, pivot - 1); // recursively quicksort the left partition of the pivot
        quickSort(array, pivot + 1, highIndex); // recursively quicksort the right partition of the pivot

    }

    public static int partition(int[] array, int lowIndex, int highIndex){
        int pivot = array[highIndex];
        int i = lowIndex - 1;

        for (int j = lowIndex; j <= highIndex - 1; j++) {
            if( array[j] < pivot) { // if the value at index j is less than pivot ....
                i++; // first move i to right then swap
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++; // move i from the last index of the low values partition to the first index of higher values partition
        int temp = array[i]; // then swap the pivot to the place of the first index of higher values partition
        array[i] = array[highIndex];
        array[highIndex] = temp;
        return i;
    }


}
