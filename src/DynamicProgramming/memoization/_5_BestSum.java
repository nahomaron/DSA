package DynamicProgramming.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _5_BestSum {
    private static final Map<Integer, List<Integer>> memo = new HashMap<>();
    public static void main(String[] args){
        System.out.println(bestSum(8, new int[]{5, 3, 4, 7}));
        System.out.println(bestSum(7, new int[]{5, 7}));
        System.out.println(bestSum(20, new int[]{2, 3, 5}));
        System.out.println(bestSum(100, new int[]{7, 25, 5, 10}));
    }

    public static List<Integer> bestSum(int target, int[] numbers){
        if(memo.containsKey(target)) return memo.get(target);
        if(target == 0) return new ArrayList<>();
        if(target < 0) return null;

        List<Integer> shortestSum = null;

        for(int n : numbers){
            int diff = target - n;
            List<Integer> diffComb = bestSum(diff, numbers);
            if(diffComb != null){
                List<Integer> comb = new ArrayList<>(diffComb);
                comb.add(n);

                if(shortestSum == null || comb.size() < shortestSum.size()){
                    shortestSum = comb;
                }
            }
        }

        memo.put(target, shortestSum);
        return shortestSum;
    }
}
