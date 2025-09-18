package DynamicProgramming.tabulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _5_BestSum {
    public static void main(String[] args){
        System.out.println(bestSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(bestSum(7, new int[]{2, 3, 5}));
        System.out.println(bestSum(8, new int[]{2, 3, 5, 4}));
        System.out.println(bestSum(100, new int[]{1, 2, 5, 14, 25, 50}));
    }

    public static List<Integer> bestSum(int target, int[] numbers){
        List<Integer>[] table = new ArrayList[target + 1];
        Arrays.fill(table, null);
        table[0] = new ArrayList<>();

        for (int i = 0; i <= target; i++) {
            if(table[i] != null){
                for(int num : numbers){
                    if(i + num <= target){
                        List<Integer> comb = new ArrayList<>(table[i]);
                        comb.add(num);
                        if(table[i + num] == null || table[i + num].size() > comb.size()){
                            table[i + num] = comb;
                        }
                    }
                }
            }
        }

        return table[target];
    }
}
