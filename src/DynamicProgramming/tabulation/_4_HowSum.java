package DynamicProgramming.tabulation;

import java.util.*;

public class _4_HowSum {
    public static void main(String[] args){
        System.out.println(howSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(howSum(7, new int[]{5, 7}));
        System.out.println(howSum(8, new int[]{2, 3, 5}));
        System.out.println(howSum(300, new int[]{7, 14}));
    }

    public static List<Integer> howSum(int target, int[] numbers){
        List<Integer>[] table = new ArrayList[target + 1];
        Arrays.fill(table, null);
        table[0] = new ArrayList<>();

        for(int i = 0; i <= target; i++){
            if(table[i] != null){
                for(int n : numbers){
                    if(i + n <= target){
                        List<Integer> newComb = new ArrayList<>(table[i]);
                        newComb.add(n);
                        table[i + n] = newComb;
                    }
                }
            }

        }
        return table[target];

    }
}
