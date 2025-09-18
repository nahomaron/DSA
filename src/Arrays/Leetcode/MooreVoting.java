package Arrays.Leetcode;

public class MooreVoting {

    public static void main(String[] args){

        int[] nums = new int[]{2,2,1,2,1,1,2};
        //for this to work we have to be guaranteed that the majority number is greater than nums.length / 2
        System.out.println("Major element: " + majorityElement(nums));

    }

    public static int majorityElement(int[] nums){

        int candidate = 0;
        int count = 0;

        for (int num: nums){
            if(count == 0) {
                candidate = num;
            }

            if(candidate == num){
                count++;
            }else{
                count--;
            }
        }

        return candidate;
    }

}
