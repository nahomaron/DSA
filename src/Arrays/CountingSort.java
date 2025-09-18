package Arrays;

import java.util.Arrays;

/*

 # Implementation
 1. An array with values to sort.
 2. A 'countingSort' method that receives an array of integers.
 3. An array inside the method to keep count of the values.
 4. A loop inside the method that counts and removes values, by incrementing elements in the counting array.
 5. A loop inside the method that recreates the array by using the counting array, so that the elements appear
    in the right order.


 # Time complexity -> O(n + k)
        best case -> O(n)
        worst case -> O(n2)

  N.B. if the numbers to be sorted varies a lot in value (large k), and there are few numbers to sort (small n),
  the Counting Sort algorithm is not effective.

 */
public class CountingSort {

    public static void main(String[] args){

        int[] numbers = { 1, 2, 1, 1, 2, 3, 4, 3, 2};

        sort(numbers);
        System.out.println(Arrays.toString(numbers));

    }

    public static void sort(int[] array) {
        // find the maximum and minimum values in the array using streams
        int min = Arrays.stream(array).min().orElse(0);
        int max = Arrays.stream(array).max().orElse(Integer.MAX_VALUE);

        // create counting array
        int[] countArray = new int[max - min + 1];
           // countArray = [3, 2, 0, 0]

        // increment the value of the index that represents the value by 1
        for (int value : array){
            countArray[value - min]++;
        }

        //reconstruct the original array in a sorted way
        int arrayIndex = 0;
        for (int i = 0; i < max - min + 1; i++) {
            // until the count of the specific index becomes 0, the value i + min added to the array consecutively
            while(countArray[i] > 0) {
                array[arrayIndex] = i + min;
                countArray[i]--;
                arrayIndex++;
            }

        }
    }
}
