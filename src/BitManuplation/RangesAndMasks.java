package BitManuplation;

/*
 Bit tricks with Ranges
 */
public class RangesAndMasks {
    public static void main(String[] args){

    }

    // 1. Building a mask with the first k bits set
    public static void buildMask(int k){
        int mask = (1 << k) - 1;
    }

    // 2. Extracting a range of bits
    public static int extractBits(int num, int i, int j){
        int mask = (1 << (j - i + 1)) - 1;  // create a mask of width (j - i + 1)
        return mask & (num >> i);
    }

    // 3. Clearing a range of bits
        // 1: Create mask with ones everywhere except that range.
        // 2: AND with number.
    public static int clearRange(int num, int i, int j){
        int left = ~0 << (j + 1);
        int right = (1 << i) - 1;
        int mask = left | right;

        return mask & num;
    }
    // 4. Updating (replacing) a range of bits
    public static int updateRange(int num, int i, int j, int value){
        num = clearRange(num, i, j);
        int mask = value << i;
        return num | mask;
    }

    // 5. Quick helper: Highest power of 2 ≤ n
    public static int highestPowerOfTwo(int n){
        n |= (n >> 1);
        n |= (n >> 2);
        n |= (n >> 4);
        n |= (n >> 8);
        n |= (n >> 16);

        return n - (n >> 1);
    }
}
