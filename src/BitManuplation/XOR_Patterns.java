package BitManuplation;

import java.util.Arrays;

public class XOR_Patterns {

    public static void main(String[] args){
        System.out.println("Single No: " + singleNumber(new int[]{1, 2, 1, 3, 4, 3, 4}));
        System.out.println("Single No III: " + Arrays.toString(singleNumberIII(new int[]{1, 2, 1, 3, 4, 3, 4, 5})));

        System.out.println("Missing No: " + missingNumber(new int[]{1, 4, 3, 0}));

        System.out.println("XOR range Queries: " + rangeXorQueries(new int[]{3, 8, 2, 6}, 1, 3));
    }
    // Single Number (LeetCode 136)
    public static int singleNumber(int[] nums){
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }

        return xor;
    }

    public static int[] singleNumberIII(int[] nums){
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }

        int diff = xor & -xor;

        int y = 0, x = 0;

        for(int num : nums){
            if((num & diff) == 0) x ^= num;
            else y ^= num;
        }

        return new int[]{x, y};
    }

    public static int missingNumber(int[] nums){
       int xor = 0;
       int n = nums.length;

       for(int i = 0; i < n; i++){
           xor ^= i ^ nums[i];
       }

       xor ^= n;
       return xor;
    }


    // Prefix XOR / Range XOR Queries
    public static int rangeXorQueries(int[] nums, int left, int right){
        int n = nums.length;

        int[] prefixXOR = new int[n + 1];
        prefixXOR[0] = 0;

        for (int i = 0; i < n; i++) {
            prefixXOR[i + 1] = prefixXOR[i] ^ nums[i];
        }

        return prefixXOR[left] ^ prefixXOR[right + 1];
    }


}
