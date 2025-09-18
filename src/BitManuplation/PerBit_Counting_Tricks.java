package BitManuplation;

public class PerBit_Counting_Tricks {

    public static void main(String[] args){
        System.out.println("XORPairSum: " + sumPairwiseXOR(new int[]{1, 2, 3}));
        System.out.println("ANDPairSum: " + sumPairwiseAND(new int[]{1, 2, 3}));
        System.out.println("SubsetXORSum: " + subsetXorSum(new int[]{1, 2, 3}));
    }

    // Sum of PariWise XOR
    public static int sumPairwiseXOR(int[] nums){
        int n = nums.length;

        long ans = 0;
        for (int j = 0; j < 32; j++) {
            long ones = 0;
            for(int num : nums){
                if(((num >> j) & 1) == 1) ones++;
            }
            long zeros = n - ones;
            ans += ones * zeros * (1L << j);
        }
        return (int) ans;
    }

    // Sum of Pairwise AND
    // key ideas
    /*  At bit position j:
            Contribution happens only when both numbers have bit j = 1.
            Count: ones = how many numbers have bit j = 1.
            Number of contributing pairs = ones * (ones - 1) / 2.
     */
    public static int sumPairwiseAND(int[] nums){
        int n = nums.length;
        long ans = 0;

        for (int j = 0; j < 32; j++) {
            long ones = 0;

            for(int num : nums){
                if(((num >> j) & 1) == 1) ones++;
            }

            long pairs = ones * (ones - 1) / 2;

            ans += pairs * (1L << j);
        }

        return (int) ans;
    }


    // Sum of Pairwise OR
    /*
        A pair contributes (1 << j) if at least one number has bit j = 1.
        Total pairs = n * (n-1) / 2.
        Pairs with both zeros at that bit: zeros = n - ones, pairsZeros = zeros * (zeros - 1) / 2;
        zeros=n−ones,pairsZeros=zeros∗(zeros−1)/2
        Contributing pairs = totalPairs - pairsZeros.
        contribution: contribj = (totalPairs - pairsZeros) * 1 << j
     */
    public static int sumPairwiseOR(int[] nums){
        int n = nums.length;
        long ans = 0;

        long totalPairs = (long) n * (n - 1) / 2;

        for (int j = 0; j < 32; j++) {
            long ones = 0;

            for(int num : nums){
                if(((num >> j) & 1) == 1) ones++;
            }

            long zeros = n - ones;
            long pairZeros = zeros * (zeros - 1) / 2;
            long contributingPairs = totalPairs - pairZeros;

            ans += contributingPairs * (1L << j);
        }

        return (int) ans;
    }

    // Sum of XOR of All Subsets
    /*
    If no number has bit j = 1 → contribution = 0.
    If at least one number has bit j = 1 →
        Half of all subsets include it in XOR result (because XOR is parity-sensitive).
        Number of subsets = 2^n.
        So contributing subsets = 2^(n-1).
        Contribution at bit j: contribj = ((1<< j) x 2^n-1)
     */

    public static long subsetXorSum(int[] nums){
        int n = nums.length;
        int bitwiseOr = 0;

        for(int num : nums){
            bitwiseOr |= num;
        }

        return (long) bitwiseOr * (1L << (n - 1));
    }

}
