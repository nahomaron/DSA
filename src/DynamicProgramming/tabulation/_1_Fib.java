package DynamicProgramming.tabulation;

import java.util.Arrays;

public class _1_Fib {
    public static void main(String[] args){
        System.out.println(fib(6));
        System.out.println(fib(7));
        System.out.println(fib(8));
        System.out.println(fib(50));
    }

    public static long fib(int n){
        long[] table = new long[n + 1];
        Arrays.fill(table, 0);
        table[1] = 1;

        for(int i = 0; i <= n; i++){
            if(i + 1 <= n)table[i + 1] += table[i];
            if(i + 2 <= n) table[i + 2] += table[i];
        }

        return table[n];
    }
}
