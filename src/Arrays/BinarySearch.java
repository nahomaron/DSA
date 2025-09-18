package Arrays;

public class BinarySearch {
    public static void main(String[] args){

        int[] numbers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = i;
//        }

        int result = binarySearch(numbers, 5);

        if (result == - 1) System.out.println("not found");
        else System.out.println("Found at index: " + result);


    }

    public static int binarySearch(int[] array, int target){
        int low = 0;
        int high = array.length - 1;


        while(low <= high) {
            int mid = (high + low) / 2;
            int midValue = array[mid];

            if (target < midValue) high = mid - 1;
            else if (target > midValue) low = mid + 1;
            else return mid;

        }

        return  - 1;
    }
}
