package DynamicProgramming.tabulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Longest_Increasing_Subsequence_construct {

    public static void main(String[] args){

        System.out.println(constructLIS(new int[]{9, 1, 4, 2, 3, 3, 7}));
    }

    public static List<Integer> constructLIS(int[] nums){

        int n = nums.length;
        if(n ==0 ) return new ArrayList<>();


        int[] dp = new int[n];  // LIS length ending at i
        int[] prev = new int[n]; // previous index at LIS ending at i

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLen = 1;
        int lastIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if(dp[i] > maxLen){
                maxLen = dp[i];
                lastIndex = i;
            }

        }

        // reconstruct the sequence

        List<Integer> lis = new ArrayList<>();

        int current = lastIndex;

        while(current != -1){
            lis.add(nums[current]);
            current = prev[current];
        }

        Collections.reverse(lis);

        return lis;

    }
}
