package DynamicProgramming.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _4_HowSum {
    private static final Map<Integer, List<Integer>> memo = new HashMap<>();
    public static void main(String[] args){
        System.out.println(howSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(howSum(7, new int[]{5, 7}));
        System.out.println(howSum(8, new int[]{2, 3, 5}));
        System.out.println(howSum(300, new int[]{7, 14}));
    }

    public static List<Integer> howSum(int target, int[] numbers){
        if(memo.containsKey(target)) return memo.get(target);
        if(target == 0) return new ArrayList<>();
        if(target < 0) return null;

        for(int n : numbers){
            int diff = target - n;
            List<Integer> result = howSum(diff, numbers);
            if(result != null){
                List<Integer> newList = new ArrayList<>(result);
                newList.add(n);
                memo.put(n, newList);
                return newList;
            }
        }
        memo.put(target, null);
        return null;
    }
}
