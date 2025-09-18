package DynamicProgramming.tabulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _3_CanSum {
    public static void main(String[] args){
        System.out.println(canSum(1, new int[]{5, 3, 4, 7}));
        System.out.println(canSum(7, new int[]{5, 7}));
        System.out.println(canSum(8, new int[]{2, 3, 5}));
        System.out.println(canSum(400, new int[]{7, 14}));
    }

    public static boolean canSum(int target, int[] numbers){
        boolean[] table = new boolean[target + 1];
        Arrays.fill(table, false);
        table[0] = true;

        for(int i = 0; i <= target; i++){
            for(int n : numbers){
                if(table[i] && i + n <= target) table[i + n] = true;
            }
        }

        return table[target];
    }
}
