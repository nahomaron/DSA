package DynamicProgramming;

import java.util.Arrays;

public class Knapsack {


    private static Integer[][] memo;

    public static void main(String[] args){
        int[] weights = new int[]{3, 2, 4, 5, 1};
        int[] values = new int[]{50, 40, 70, 80, 10};
        int n = weights.length;
        int capacity = 7;

        memo = new Integer[n][capacity + 1];

//        int result = knapsack_memoization(weights, values, 0, capacity);
        int tabulation_result = knapsack_tabulation_space_optimized(weights, values, capacity);

        System.out.println("Max_benefit: " + tabulation_result);


    }

    // top-bottom / memoization
    public static int knapsack_memoization(int[] weights, int[] values, int i, int capacity){
        if(i == weights.length || capacity == 0){
            return 0;
        }

        if(memo[i][capacity] != null) return memo[i][capacity];

        int notPick = knapsack_memoization(weights, values, i + 1, capacity);

        int pick = 0;
        if(weights[i] <= capacity){
            pick = values[i] + knapsack_memoization(weights, values, i + 1, capacity - weights[i]);
        }

        return memo[i][capacity] = Math.max(notPick, pick);
    }

    // bottom-up / tabulation
    public static int knapsack_tabulation(int[] weights, int[] values, int capacity){
       int n = weights.length;

       int[][] dp = new int[n][capacity + 1];

        for (int w = weights[0]; w < capacity + 1; w++) {
            if(weights[0] <= w){
                dp[0][w] = values[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int w = 0; w < capacity + 1; w++) {
                int notPick = dp[i - 1][w];

                int pick = 0;
                if(weights[i] <= w){
                    pick = values[i] + dp[i - 1][w - weights[i]];
                }

                dp[i][w] = Math.max(notPick, pick);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int w = 0; w < capacity + 1; w++) {
                System.out.printf("%5d", dp[i][w]);
            }
            System.out.println();
        }

        return dp[n-1][capacity];
    }

    // bottom-up / space optimized tabulation
    public static int knapsack_tabulation_space_optimized(int[] weights, int[] values, int capacity){
        int n = weights.length;
        int[] prev = new int[capacity + 1];

        for (int i = 0; i < n; i++) {
            int[] curr = new int[capacity + 1];

            for (int w = 0; w < capacity + 1; w++) {
                int notPick = prev[w];
                int pick = 0;
                if(weights[i] <= w){
                    pick = values[i] + prev[w - weights[i]];
                }

                curr[w] = Math.max(notPick, pick);
            }

            prev = curr;
        }

        return prev[capacity];
    }

}
