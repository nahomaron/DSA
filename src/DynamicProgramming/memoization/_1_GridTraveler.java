package DynamicProgramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class _1_GridTraveler {
    private static final Map<String, Long> memo = new HashMap<>();
    public static void main(String[] args){
        System.out.println(gridTraveler(2,3));
        System.out.println(gridTraveler(1,1));
        System.out.println(gridTraveler(3,3));
        System.out.println(gridTraveler(18,18));
    }

    public static long gridTraveler(int m, int n){
        String key = m + "," + n;
        if(memo.containsKey(key)) return memo.get(key);
        if(m == 1 && n == 1) return 1;
        if(m == 0 || n == 0) return 0;

        memo.put(key, gridTraveler(m - 1, n) + gridTraveler(m, n - 1));

        return memo.get(key);
    }
}
