package DynamicProgramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class _2_Fib {
    private static Map<Integer, Long> map = new HashMap<>();
    public static void main(String[] args){
        System.out.println(fib(6));
        System.out.println(fib(7));
        System.out.println(fib(8));
        System.out.println(fib(100));
    }

    public static long fib(int n){
        if(map.containsKey(n)) return map.get(n);
        if(n <= 2 ) return 1;

        long result = fib(n - 1) + fib(n - 2);
        map.put(n, result);

        return result;
    }
}
