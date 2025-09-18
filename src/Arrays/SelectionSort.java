package Arrays;

import java.util.Arrays;

/* Selection Sort
   - is an algorithm that finds the lowest value in the array and moves it to the front of the unsorted array

   # How it works
   1. Go through the array to find the lowest value
   2. move the lowest value to the front
   3. Do this as many times as the size of the array - 1

   # Time complexity is O(n2)

 */
public class SelectionSort {

    public static void main(String[] args){

        int [] numbers = {64, 34, 25, 12, 22, 11, 90, 5};

//      first we loop through the array to find the index with the lowest number
        for (int i = 0; i < numbers.length - 1; i++) {
            int min_index = i; // initially assign mini_index to i
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[min_index])
                    min_index = j;
            }

//       # Shifting the elements
//          - The idea here is to shift elements to the right to make space for the
//            min_number at index i.

//            int min_number = numbers[min_index]; // we set the minimum number
//            for (int k = min_index; k > i; k--) {
//                numbers[k] = numbers[k-1];
//            }
//            numbers[i] = min_number;

//            ### Instead of shifting all elements to the right, its better to swap the smallest number with
//                the first one

            int temp = numbers[min_index];
            numbers[min_index] = numbers[i];
            numbers[i] = temp;

        }
        System.out.println("Selection sorted: ");
        System.out.println(Arrays.toString(numbers));
    }

}
