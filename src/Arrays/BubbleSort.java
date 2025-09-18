package Arrays;


/* Bubble sort
    - is an algorithm that sorts an array from the lowest to the highest
    - the world bubble means that it makes the highest value bubble up

    # how it works
    1. go through the array, one value at a time
    2. for each value compare it with the next value
    3. if the value is greater than the next one, swap them and make the highest value come last
    4. do this as many times as the number of values in the array = array size


    # Time complexity
    The Bubble Sort algorithm loops through every value in the array, comparing it to the value next
    to it. So for an array of n values, there must be n such comparisons in one loop.
    And after one loop, the array is looped through again and again n times.

    so its O(n2)

    - the run time increases really fast when the size of the array is increased.

*/

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){

        int [] numbers = {64, 34, 25, 12, 22, 11, 90, 5};
        int temp;

//       for(int i = 0; i < numbers.length; i++){
//           for (int j = i + 1; j < numbers.length; j++) {
//               if( numbers[i] > numbers[j]){
//                   temp = numbers[i];
//                   numbers[i] = numbers[j];
//                   numbers[j] = temp;
//               }
//           }
//       }

//   the problem in the above method is though that in the case of [7, 3, 10, 11], the array will be
//   sorted in the first run, but the program will loop the same size of the array (which is 4 ) in
//   this case without swapping elements, and this is not necessary. so, we can fix it like this:


        for(int i = 0; i < numbers.length; i++){
            boolean swapped = false;
            for (int j = i + 1; j < numbers.length; j++) {
                if( numbers[i] > numbers[j]){
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
        System.out.println("Bubble Sorted: ");
        System.out.println(Arrays.toString(numbers));


    }
}
