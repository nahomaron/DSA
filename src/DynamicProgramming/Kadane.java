package DynamicProgramming;

public class Kadane {

    public static void main(String[] args){
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(kadane(nums));
    }

    public static int kadane(int[] nums){

        int globalMax = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxSoFar = Math.max(nums[i], nums[i] + maxSoFar);

            globalMax = Math.max(globalMax, maxSoFar);
        }

        return globalMax;
    }
}
