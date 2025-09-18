package Arrays;


/*Radix Sort algorithm
    - sorts an array by individual digits, starting with the least significant digit (the rightmost one).
    - Radix Sort uses the radix so that decimal values are put into 10 different buckets (or containers) corresponding
       to the digit that is in focus, then put back into the array before moving on to the next digit.


   # Time Complexity is O(k.n)


 */
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class RadixSort {

    public static void main(String[] args){
//        int[] numbers = new int[] {2423, 1223, 3112, -4234, 2754, 1679};

        int[] numbers = new int[10];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000000);
        }
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void sort(int[] arr){
        Map<Boolean, List<Integer>> splitArray = Arrays.stream(arr).boxed()
                .collect(Collectors.partitioningBy(i -> i < 0));

        int[] negativeInts = radixSort(
                splitArray.get(true).stream()
                        .mapToInt(Integer::intValue)
                        .map(Math::abs).toArray()
        );

        int[] positiveInts = radixSort(
                splitArray.get(false).stream()
                        .mapToInt(Integer::intValue)
                        .toArray()
        );

        for (int i = negativeInts.length - 1, j = 0; i >=0; i--, j++){
            arr[j] = -negativeInts[i];
            System.arraycopy(positiveInts, 0, arr, negativeInts.length, positiveInts.length);
        }



    }

    private static int[] radixSort(int[] array){
        int max = Arrays.stream(array).max().orElse(Integer.MAX_VALUE);
        for (int exp = 1; max/exp > 0 ; exp *= 10) {
            countingSort(array, exp);
        }
        return array;
    }

    private static void countingSort(int[] array, int exp) {

        // create counting array
        int[] countArray = new int[10];
        // countArray = [3, 2, 0, 0]

        // increment the value of the index that represents the value by 1
        for (int value : array){
            countArray[ (value/exp) % 10 ]++;
        }
//        System.out.println("Count array" + Arrays.toString(countArray));
        /* Right now, countArray[i] only tells us how many times each digit appears, but we need to know where each digit
        should be placed in the sorted array. To achieve this, we convert frequencies into cumulative sums. */

        for (int i = 1; i < 10; i++) {
            countArray[i] += countArray[i -1];
        }
//        System.out.println("Cumulative sums array" + Arrays.toString(countArray));


        int[] output = new int[array.length];

        for (int i = array.length -1; i >= 0; i--) {
            int current = array[i];
            int digit = (current / exp) % 10;
            int positionInArray = countArray[digit] - 1;
            output[positionInArray] = current;
            countArray[digit]--;
        }
        System.arraycopy(output, 0, array, 0, array.length);
    }
}
