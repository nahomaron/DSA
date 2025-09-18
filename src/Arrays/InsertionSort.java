package Arrays;

import java.util.Arrays;

/*  Insertion sort
   - is an algorithm that uses one part of the array to hold sorted values and the other part to hold
     unsorted values

     # how it works
     1. An outer loop that picks a value to be sorted. For an array with n values, this outer
      loop skips the first value, and must run n -1 times.
     2. An inner loop that goes through the sorted part of the array, to find where to insert the value.
       - If the value to be sorted is at index i, the sorted part of the array starts at index 0 and ends
       at index i−1.

      # Time complexity is O(n2)
 */
public class InsertionSort {
    public static void main(String[] args){

        int [] numbers = {64, 34, 25, 12, 22, 11, 90, 5};


        for (int i = 1; i < numbers.length; i++) {

            int currentValue = numbers[i];

            int j = i - 1;

             while (j >= 0 && numbers[j] > currentValue){
                 numbers[j + 1 ] = numbers[j];
                 j--;
             }

             numbers[j + 1] = currentValue; //
        }

        System.out.println("Insertion sorted:");
        System.out.println(Arrays.toString(numbers));

    }
}
