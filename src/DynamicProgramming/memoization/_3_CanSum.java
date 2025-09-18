package DynamicProgramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class _3_CanSum {
    private static final Map<Integer, Boolean> memo = new HashMap<>();
    public static void main(String[] args){
        System.out.println(canSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(canSum(7, new int[]{5, 7}));
        System.out.println(canSum(8, new int[]{2, 3, 5}));
        System.out.println(canSum(400, new int[]{7, 14}));
    }

    public static boolean canSum(int target, int[] numbers){
        if(memo.containsKey(target)) return memo.get(target);

        if(target < 0) return false;
        if(target == 0) return true;

        for(int n : numbers){
            int diff = target - n;
            memo.put(diff, canSum(diff, numbers));
            if(memo.get(diff)) return true;
        }

        memo.put(target, false);
        return false;
    }
}
